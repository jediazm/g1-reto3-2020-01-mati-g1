package co.edu.uniandes.tianguix.notificator;

import co.edu.uniandes.tianguix.commons.model.Notification;
import co.edu.uniandes.tianguix.commons.plugin.NotificationProviderPlugin;
import co.edu.uniandes.tianguix.notificator.rest.SlackClient;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Slf4j
public class SlackPlugin extends Plugin {

	public SlackPlugin(PluginWrapper wrapper) {

		super(wrapper);
	}

	@Override public void start() {

		log.info("Slack Notification Provider is ready to be used");
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------------------------------------------------------

	@Extension
	public class SlackNotificationProvider implements NotificationProviderPlugin {

		private SlackClient slackClient;

		public SlackNotificationProvider() {

			slackClient = new SlackClient();
		}

		@Override
		public void notify(Notification notification) {

			var message = getNotificationMessage(notification);
			slackClient.sendMessage(message);

		}

		// -------------------------------------------------------------------------------------------------------------
		// Inner logic
		// -------------------------------------------------------------------------------------------------------------

		private String getNotificationMessage(Notification notification) {

			return getNotificationTemplate()
					.replace("orderType", notification.getType().toString())
					.replace("orderId", notification.getOrderId())
					.replace("recipients", notification.getRecipients().toString());
		}

		private String getNotificationTemplate() {

			var inputStream = getClass().getClassLoader().getResourceAsStream("notification.json");
			var reader = new BufferedReader(new InputStreamReader(inputStream));
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		}

	}

}


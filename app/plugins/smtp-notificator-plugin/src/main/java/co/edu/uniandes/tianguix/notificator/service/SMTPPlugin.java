package co.edu.uniandes.tianguix.notificator.service;

import co.edu.uniandes.tianguix.commons.model.Notification;
import co.edu.uniandes.tianguix.commons.plugin.NotificationProviderPlugin;
import co.edu.uniandes.tianguix.notificator.smtp.SMTPClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Slf4j
public class SMTPPlugin extends Plugin {

    public SMTPPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Extension
    public static class PluginImpl implements NotificationProviderPlugin {
        // -----------------------------------------------------------------------------------------------------------------
        // Attributes
        // -----------------------------------------------------------------------------------------------------------------

        private final SMTPClient smtpClient = new SMTPClient();

        @Override
        public void notify(Notification notification) {

            var message = getNotificationMessage(notification);
            smtpClient.sendMessage(message);

        }

        // -----------------------------------------------------------------------------------------------------------------
        // Inner logic
        // -----------------------------------------------------------------------------------------------------------------

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

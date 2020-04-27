package co.edu.uniandes.tianguix.mq.listener;

import co.edu.uniandes.tianguix.commons.model.Notification;
import co.edu.uniandes.tianguix.commons.plugin.NotificationProviderPlugin;
import co.edu.uniandes.tianguix.data.provider.PluginsProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.pf4j.JarPluginManager;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

/**
 * @author <a href="mailto:d.bellonc@unaindes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationsListener {

	private final PluginsProvider pluginsProvider;

	@RabbitListener(queues = "notifications.queue")
	public void onMessage(Notification notification) {

		log.info("Message received: '{}'", notification);

		var plugins = pluginsProvider.getPlugins();

		if (!plugins.isEmpty()) {

			var pluginManager = new JarPluginManager();
			plugins.forEach(plugin -> pluginManager.loadPlugin(Paths.get(plugin.getPath())));
			pluginManager.startPlugins();

			log.info("plugins successful loaded");

			var notificationProviders = pluginManager.getExtensions(NotificationProviderPlugin.class);
			notificationProviders.forEach(plugin -> plugin.notify(notification));
		} else {
			log.info("There is o notifications provider available");
		}
	}
}

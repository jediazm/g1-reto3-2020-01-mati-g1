package co.edu.uniandes.tianguix.mq.listener;

import co.edu.uniandes.tianguix.commons.model.Notification;
import co.edu.uniandes.tianguix.commons.plugin.NotificationProviderPlugin;
import co.edu.uniandes.tianguix.data.provider.PluginsProvider;
import co.edu.uniandes.tianguix.data.provider.model.Plugin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.JarPluginManager;
import org.pf4j.PluginManager;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
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
		// var path = plugins.stream().findFirst().map(Plugin::getPath).orElse("");
		var path = "/Users/daniel.bellon/Documents/MATI/g1-reto3-2020-01-mati-g1/plugins-store/slack-notificator-plugin-0.0.1-SNAPSHOT.jar";

		var pluginsRoot = Paths.get(path);

		var pluginManager = new JarPluginManager();

		pluginManager.loadPlugin(pluginsRoot);
		pluginManager.startPlugins();

		var notificationProviders = pluginManager.getExtensions(NotificationProviderPlugin.class);
		notificationProviders.forEach(plugin -> plugin.notify(notification));
	}
}

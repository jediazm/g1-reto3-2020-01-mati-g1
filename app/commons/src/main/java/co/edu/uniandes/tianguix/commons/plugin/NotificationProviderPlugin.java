package co.edu.uniandes.tianguix.commons.plugin;

import co.edu.uniandes.tianguix.commons.model.Notification;
import org.pf4j.ExtensionPoint;

/**
 * Definition of the Plugin contract that must be implemented for each plugin
 * able to sent notifications
 *
 * @author <a href="mailto:d.bellonc@unaindes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@FunctionalInterface
public interface NotificationProviderPlugin extends ExtensionPoint {

	/**
	 * Should receive a {@link Notification} instance and sent it to its recipients
	 * through the plugin communication channel
	 *
	 * @param notification the {@link Notification} to be sent
	 */
	void notify(Notification notification);
}

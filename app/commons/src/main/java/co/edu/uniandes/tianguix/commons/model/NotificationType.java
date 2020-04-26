package co.edu.uniandes.tianguix.commons.model;

/**
 * All the notifications types that can be sent through Tianguix
 *
 * @author <a href="mailto:d.bellonc@uniandes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
public enum NotificationType {

	/**
	 * Notification sent when a Tianguix order is created
	 */
	ORDER_CREATION,

	/**
	 * Notification sent when a Tianguix order is updated
	 */
	ORDER_UPDATE,

	/**
	 * Notification sent when a Tianguix notification (no matter if it s a sale or a purchase)
	 * do match when an existing set of orders
	 */
	ORDER_MATCH
}

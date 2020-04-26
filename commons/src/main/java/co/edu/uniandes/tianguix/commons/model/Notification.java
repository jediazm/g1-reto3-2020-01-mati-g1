package co.edu.uniandes.tianguix.commons.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Collection;

/**
 * The model that represents the notification that is gonna be sent
 * through the notification filter
 *
 * @author <a href="mailto:da.bellonc@uniandes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

	@With private NotificationType type;
	@With private String orderId;
	@With private Collection<User> recipients;

}

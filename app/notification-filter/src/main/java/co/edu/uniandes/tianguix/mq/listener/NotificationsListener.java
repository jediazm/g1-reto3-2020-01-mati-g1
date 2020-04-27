package co.edu.uniandes.tianguix.mq.listener;

import co.edu.uniandes.tianguix.commons.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:d.bellonc@unaindes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@Slf4j
@Component
public class NotificationsListener {

	@RabbitListener(queues = "notifications.queue")
	public void onMessage(Notification notification) {

		log.info("Message received: '{}'", notification);
	}
}

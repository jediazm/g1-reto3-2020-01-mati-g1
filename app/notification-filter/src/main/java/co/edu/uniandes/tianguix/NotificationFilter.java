package co.edu.uniandes.tianguix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author <a href="mailto:d.bellonc@uniandes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@Slf4j
@EnableRabbit
@EnableFeignClients
@SpringBootApplication
public class NotificationFilter {

	public static void main(String[] args) {

		SpringApplication.run(NotificationFilter.class, args);
	}
}

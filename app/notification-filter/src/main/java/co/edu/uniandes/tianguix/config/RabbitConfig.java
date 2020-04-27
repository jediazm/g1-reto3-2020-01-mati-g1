package co.edu.uniandes.tianguix.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:d.bellonc@uniandes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@Configuration
public class RabbitConfig {

	@Bean
	public Jackson2JsonMessageConverter converter() {

		return new Jackson2JsonMessageConverter();
	}
}
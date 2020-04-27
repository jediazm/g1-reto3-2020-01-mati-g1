package co.edu.uniandes.tianguix.notificator.rest;

import lombok.var;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author <a href="mailto:d.bellonc@uniandes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
public class SlackClient {

	public SlackClient() {

	}

	// -----------------------------------------------------------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------------------------------------------------------

	private String slackUrl = "https://hooks.slack.com/services/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";

	// -----------------------------------------------------------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------------------------------------------------------

	public String sendMessage(String message) {

		var restTemplate = new RestTemplate();
		var headers = new HttpHeaders();

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		return restTemplate.exchange(
				slackUrl,
				HttpMethod.POST,
				new HttpEntity<>(message, headers),
				String.class).getBody();
	}
}

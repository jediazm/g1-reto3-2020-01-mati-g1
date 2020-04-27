package co.edu.uniandes.tianguix.data.provider.rest.client;

import co.edu.uniandes.tianguix.data.provider.model.Plugin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since 0.0.1
 */
@FeignClient(name = "plugins.registry", url = "${registry.url}")
public interface RegistryClient {

	@GetMapping("/plugins")
	Collection<Plugin> getPlugins();
}

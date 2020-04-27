package co.edu.uniandes.tianguix.data.provider;

import co.edu.uniandes.tianguix.data.provider.model.Plugin;
import co.edu.uniandes.tianguix.data.provider.rest.client.RegistryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author <a href="mailto:dbellonc@uniandes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class PluginsProviderImpl implements PluginsProvider {

	private final RegistryClient registryClient;

	@Override public Collection<Plugin> getPlugins() {

		return registryClient.getPlugins();
	}
}

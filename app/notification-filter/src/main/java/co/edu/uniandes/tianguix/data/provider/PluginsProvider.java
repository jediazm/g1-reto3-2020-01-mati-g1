package co.edu.uniandes.tianguix.data.provider;

import co.edu.uniandes.tianguix.data.provider.model.Plugin;

import java.util.Collection;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since 0.0.1
 */
public interface PluginsProvider {

	Collection<Plugin>  getPlugins();
}

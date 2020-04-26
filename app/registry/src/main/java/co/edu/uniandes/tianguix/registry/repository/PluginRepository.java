package co.edu.uniandes.tianguix.registry.repository;

import co.edu.uniandes.tianguix.registry.model.Plugin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PluginRepository extends CrudRepository<Plugin, Integer> {

    List<Plugin> findByType(String type);
}

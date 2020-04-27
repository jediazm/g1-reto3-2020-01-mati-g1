package co.edu.uniandes.tianguix.registry.entrypoint;

import co.edu.uniandes.tianguix.registry.model.Plugin;
import co.edu.uniandes.tianguix.registry.repository.PluginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/plugins")
public class PluginsController {

	private final PluginRepository pluginRepository;
	@Value("${plugins.path}") private String pluginsPath;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity uploadPlugin(@RequestPart("file") MultipartFile file,
									   @RequestPart("name") String name,
									   @RequestPart("type") String type) {

		try {

			Path path = Paths.get(pluginsPath + name);
			Path pathSaved = Files.write(path, file.getBytes(), StandardOpenOption.CREATE);
			Plugin plugin = Plugin.builder()
							   .name(name)
							   .path(pathSaved.toAbsolutePath().toString())
							   .type(type)
							   .build();

			Plugin pluginSaved = pluginRepository.save(plugin);
			return ResponseEntity.ok(pluginSaved);

		} catch (IOException e) {

			log.error(e.getMessage(), e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping()
	public ResponseEntity<List<Plugin>> getAllPlugins(@RequestParam(required = false) String type) {

		List<Plugin> plugins = Optional.ofNullable(type).map(pluginRepository::findByType).orElse(getAllPlugins());
		return ResponseEntity.ok(plugins);
	}

	private List<Plugin> getAllPlugins() {

		return StreamSupport.stream(pluginRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}

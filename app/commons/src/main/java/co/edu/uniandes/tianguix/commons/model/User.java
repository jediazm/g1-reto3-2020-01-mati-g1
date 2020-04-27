package co.edu.uniandes.tianguix.commons.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.io.Serializable;

/**
 * Model that defines the attributes for a Tianguix user
 *
 * @author <a href="mailto:d.bellonc@uniandes.edu.co"> Daniel Bellón </a>
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	@With private String uuid;
	@With private String name;
	@With private String email;

}

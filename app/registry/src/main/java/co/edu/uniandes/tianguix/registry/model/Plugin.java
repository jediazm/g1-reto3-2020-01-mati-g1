package co.edu.uniandes.tianguix.registry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "plugins")
public class Plugin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "plugin_name") private String name;
    @Column(name = "path") private String path;
    @Column(name = "type") private String type;
}


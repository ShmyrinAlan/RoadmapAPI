package kz.alan.roadmapapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "roadmaps")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roadmap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "roadmap", cascade = CascadeType.ALL)
    private List<Module>  modules;

    @ManyToMany(mappedBy = "roadmaps")
    private List<Users> users;
}

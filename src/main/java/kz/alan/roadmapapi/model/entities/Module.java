package kz.alan.roadmapapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Table(name = "modules")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "roadmap_id")
    private Roadmap roadmap;

    @ManyToMany(mappedBy = "modules")
    private List<Users> users;

    @ManyToMany
    @JoinTable(name = "modulesRealations", joinColumns = @JoinColumn(name = "module_id"), inverseJoinColumns = @JoinColumn(name = "next_module_id"))
    private Set<Module> previousModules;
    @ManyToMany(mappedBy = "previousModules")
    private Set<Module> nextModules;
}

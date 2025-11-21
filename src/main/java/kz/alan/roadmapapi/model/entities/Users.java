package kz.alan.roadmapapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "app_user")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @ManyToMany
    @JoinTable(name = "usersRoadmap", joinColumns = @JoinColumn(name = "usersId"), inverseJoinColumns = @JoinColumn(name = "roadmapId"))
    private List<Roadmap> roadmaps;

    @ManyToMany
    @JoinTable(name = "usersModule", joinColumns = @JoinColumn(name = "usersId"), inverseJoinColumns = @JoinColumn(name = "moduleId"))
    private List<Module> modules;
}

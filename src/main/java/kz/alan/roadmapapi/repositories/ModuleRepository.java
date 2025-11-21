package kz.alan.roadmapapi.repositories;

import kz.alan.roadmapapi.model.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}

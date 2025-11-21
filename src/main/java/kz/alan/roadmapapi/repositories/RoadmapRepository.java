package kz.alan.roadmapapi.repositories;

import kz.alan.roadmapapi.model.entities.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {
}

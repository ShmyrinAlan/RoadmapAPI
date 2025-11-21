package kz.alan.roadmapapi.repositories;

import kz.alan.roadmapapi.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}

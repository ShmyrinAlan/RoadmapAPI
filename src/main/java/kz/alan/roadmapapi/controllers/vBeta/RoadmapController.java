package kz.alan.roadmapapi.controllers.vBeta;

import kz.alan.roadmapapi.model.dtos.RoadmapDTO;
import kz.alan.roadmapapi.model.dtos.UserDTO;
import kz.alan.roadmapapi.model.dtos.UserOutDTO;
import kz.alan.roadmapapi.model.dtos.shorts.RoadmapShortDTO;
import kz.alan.roadmapapi.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vBeta/roadmaps")
public class RoadmapController {

    @Autowired
    private ServiceInterface<RoadmapDTO, RoadmapDTO, Long> service;

    @Autowired
    private ServiceInterface<UserDTO, UserOutDTO, Long> userService;

    @GetMapping("")
    public ResponseEntity<?> getRoadmaps() {
        return ResponseEntity.ok(service.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoadmap(@PathVariable Long id) {
        return ResponseEntity.ok(service.read(id));
    }

    @PostMapping
    public ResponseEntity<?> createRoadmap(@RequestBody RoadmapDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoadmap(@RequestBody RoadmapDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchRoadmap(@RequestBody RoadmapDTO dto, @PathVariable Long id) {
        if(dto.getUsers() != null){
            dto.getUsers().forEach(u -> {
                userService.updatePartial(u.getId(),UserDTO.builder().roadmaps(List.of(RoadmapShortDTO.builder().id(id).build())).build());
            });
        }
        return ResponseEntity.ok(service.updatePartial(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoadmap(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/{id}/modules")
    public ResponseEntity<?> getModules(@PathVariable Long id) {
        return ResponseEntity.ok(service.read(id).getModules());
    }
}

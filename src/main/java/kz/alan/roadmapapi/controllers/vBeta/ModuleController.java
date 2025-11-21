package kz.alan.roadmapapi.controllers.vBeta;

import kz.alan.roadmapapi.model.dtos.ModuleDTO;
import kz.alan.roadmapapi.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vBeta/modules")
public class ModuleController {
    @Autowired
    private ServiceInterface<ModuleDTO, ModuleDTO, Long> service;

    @PostMapping
    public ResponseEntity<?> saveModule(@RequestBody ModuleDTO moduleDTO) {
        return ResponseEntity.ok(service.create(moduleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateModule(@PathVariable Long id, @RequestBody ModuleDTO moduleDTO) {
        return ResponseEntity.ok(service.update(id, moduleDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchModule(@PathVariable Long id, @RequestBody ModuleDTO moduleDTO) {
        return ResponseEntity.ok(service.updatePartial(id, moduleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}

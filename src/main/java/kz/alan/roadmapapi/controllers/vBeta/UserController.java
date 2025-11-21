package kz.alan.roadmapapi.controllers.vBeta;

import kz.alan.roadmapapi.mappers.UserMapper;
import kz.alan.roadmapapi.model.dtos.UserDTO;
import kz.alan.roadmapapi.model.dtos.UserInDTO;
import kz.alan.roadmapapi.model.dtos.UserOutDTO;
import kz.alan.roadmapapi.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vBeta/users")
public class UserController {
    @Autowired
    private ServiceInterface<UserDTO, UserOutDTO, Long> service;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    UserMapper mapper;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserInDTO user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return new ResponseEntity<>(service.create(mapper.toDTO(user)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/roadmaps")
    public ResponseEntity<?> getUserRoadmapsById(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id).getRoadmaps(), HttpStatus.OK);
    }

    @GetMapping("/{id}/modules")
    public ResponseEntity<?> getUserModulesById(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id).getModules(), HttpStatus.OK);
    }

    @PatchMapping("/{id}/patch")
    public ResponseEntity<?> updateUserPassword(@PathVariable Long id, @RequestBody UserInDTO user) {
        return new ResponseEntity<>(service.updatePartial(id, mapper.toDTO(user)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}

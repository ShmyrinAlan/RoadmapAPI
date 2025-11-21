package kz.alan.roadmapapi.services.realizations;

import kz.alan.roadmapapi.mappers.UserMapper;
import kz.alan.roadmapapi.model.dtos.UserDTO;
import kz.alan.roadmapapi.model.dtos.UserOutDTO;
import kz.alan.roadmapapi.model.dtos.shorts.ModuleShortDTO;
import kz.alan.roadmapapi.model.dtos.shorts.RoadmapShortDTO;
import kz.alan.roadmapapi.repositories.UserRepository;
import kz.alan.roadmapapi.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements ServiceInterface<UserDTO, UserOutDTO, Long> {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserOutDTO create(UserDTO dto) {
        dto.setId(null);
        try{
            return mapper.toOutDTO(repo.save(mapper.toEntity(dto)));
        }catch (DataIntegrityViolationException e){
            return null;
        }
    }

    @Override
    public List<UserOutDTO> read() {
        return mapper.toOutDTO(repo.findAll());
    }

    @Override
    public UserOutDTO read(Long aLong) {
        return mapper.toOutDTO(repo.findById(aLong).orElse(null));
    }

    @Override
    public UserOutDTO update(Long aLong, UserDTO dto) {
        UserDTO gottenDto = mapper.toDTO(repo.findById(aLong).orElse(null));
        if(gottenDto == null) return null;
        repo.delete(mapper.toEntity(gottenDto));
        dto.setId(aLong);
        return mapper.toOutDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public UserOutDTO updatePartial(Long aLong, UserDTO dto) {
        UserDTO gottenDto = mapper.toDTO(repo.findById(aLong).orElse(null));
        if(gottenDto == null) return null;

        if(dto.getEmail() != null) gottenDto.setEmail(dto.getEmail());
        if(dto.getPassword() != null) gottenDto.setPassword(dto.getPassword());
        if(dto.getUsername() != null) gottenDto.setUsername(dto.getUsername());
        if(dto.getModules() != null){
            List<ModuleShortDTO> ans =  gottenDto.getModules();
            ans.addAll(dto.getModules());
            gottenDto.setModules(ans.stream().distinct().collect(Collectors.toMap(ModuleShortDTO::getId, u->u, (u1,u2)->u1)).values().stream().toList());
        }
        if(dto.getRoadmaps() != null) {
            List<RoadmapShortDTO> ans = gottenDto.getRoadmaps();
            ans.addAll(dto.getRoadmaps());
            gottenDto.setRoadmaps(ans.stream().distinct().collect(Collectors.toMap(RoadmapShortDTO::getId, u->u,(u1,u2)->u1)).values().stream().toList());
        }

        return mapper.toOutDTO(repo.save(mapper.toEntity(gottenDto)));
    }

    @Override
    public boolean delete(Long aLong) {
        try {
            repo.deleteById(aLong);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }
}

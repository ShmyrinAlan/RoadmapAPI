package kz.alan.roadmapapi.services.realizations;

import kz.alan.roadmapapi.mappers.RoadmapMapper;
import kz.alan.roadmapapi.model.dtos.RoadmapDTO;
import kz.alan.roadmapapi.model.dtos.shorts.ModuleShortDTO;
import kz.alan.roadmapapi.model.dtos.shorts.UserShortDTO;
import kz.alan.roadmapapi.repositories.RoadmapRepository;
import kz.alan.roadmapapi.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoadmapService implements ServiceInterface<RoadmapDTO, RoadmapDTO, Long> {

    @Autowired
    RoadmapRepository repo;

    @Autowired
    RoadmapMapper mapper;

    @Override
    public RoadmapDTO create(RoadmapDTO dto) {
        dto.setId(null);
        try{
            return mapper.toDTO(repo.save(mapper.toEntity(dto)));
        }catch (DataIntegrityViolationException e){
            return null;
        }
    }

    @Override
    public List<RoadmapDTO> read() {
        return mapper.toDTO(repo.findAll());
    }

    @Override
    public RoadmapDTO read(Long aLong) {
        return mapper.toDTO(repo.findById(aLong).orElse(null));
    }

    @Override
    public RoadmapDTO update(Long aLong, RoadmapDTO dto) {
        RoadmapDTO gottenDto = mapper.toDTO(repo.findById(aLong).orElse(null));
        if(gottenDto == null) return null;
        repo.delete(mapper.toEntity(gottenDto));
        dto.setId(aLong);
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public RoadmapDTO updatePartial(Long aLong, RoadmapDTO dto) {
        RoadmapDTO gottenDto = mapper.toDTO(repo.findById(aLong).orElse(null));
        if(gottenDto == null) return null;

        if(dto.getName() != null) gottenDto.setName(dto.getName());
        if(dto.getDescription() != null) gottenDto.setDescription(dto.getDescription());
        if(dto.getUsers() != null){
            List<UserShortDTO> ans =  gottenDto.getUsers();
            ans.addAll(dto.getUsers());
            gottenDto.setUsers(ans.stream().distinct().collect(Collectors.toMap(UserShortDTO::getId, u->u, (u1,u2)->u1)).values().stream().toList());
        }
        if(dto.getModules() != null) {
            List<ModuleShortDTO> ans =  gottenDto.getModules();
            ans.addAll(dto.getModules());
            gottenDto.setModules(ans.stream().distinct().collect(Collectors.toMap(ModuleShortDTO::getId, u->u, (u1,u2)->u1)).values().stream().toList());
        }

        return mapper.toDTO(repo.save(mapper.toEntity(gottenDto)));
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

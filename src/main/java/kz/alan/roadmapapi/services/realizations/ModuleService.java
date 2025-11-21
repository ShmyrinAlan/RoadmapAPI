package kz.alan.roadmapapi.services.realizations;

import kz.alan.roadmapapi.mappers.ModuleMapper;
import kz.alan.roadmapapi.model.dtos.ModuleDTO;
import kz.alan.roadmapapi.repositories.ModuleRepository;
import kz.alan.roadmapapi.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService implements ServiceInterface<ModuleDTO, ModuleDTO, Long> {

    @Autowired
    private ModuleRepository repo;

    @Autowired
    private ModuleMapper mapper;

    @Override
    public ModuleDTO create(ModuleDTO dto) {
        dto.setId(null);
        try{
            return mapper.toDTO(repo.save(mapper.toEntity(dto)));
        }catch (DataIntegrityViolationException e){
            return null;
        }
    }

    @Override
    public List<ModuleDTO> read() {
        return mapper.toDTO(repo.findAll());
    }

    @Override
    public ModuleDTO read(Long aLong) {
        return mapper.toDTO(repo.findById(aLong).orElse(null));
    }

    @Override
    public ModuleDTO update(Long aLong, ModuleDTO dto) {
        ModuleDTO gottenDto = mapper.toDTO(repo.findById(aLong).orElse(null));
        if(gottenDto == null) return null;
        repo.delete(mapper.toEntity(gottenDto));
        dto.setId(aLong);
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public ModuleDTO updatePartial(Long aLong, ModuleDTO dto) {
        ModuleDTO gottenDto = mapper.toDTO(repo.findById(aLong).orElse(null));
        if(gottenDto == null) return null;

        if(dto.getName() != null) gottenDto.setName(dto.getName());
        if(dto.getDescription() != null) gottenDto.setDescription(dto.getDescription());
        if(dto.getRoadmap() != null) gottenDto.setRoadmap(dto.getRoadmap());
        if(dto.getNextModules() != null) gottenDto.setNextModules(dto.getNextModules());
        if(dto.getPreviousModules() != null) gottenDto.setPreviousModules(dto.getPreviousModules());

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

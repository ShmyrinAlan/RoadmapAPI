package kz.alan.roadmapapi.mappers;

import kz.alan.roadmapapi.model.dtos.ModuleDTO;
import kz.alan.roadmapapi.model.dtos.shorts.ModuleShortDTO;
import kz.alan.roadmapapi.model.entities.Module;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModuleMapper {
    ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);
    ModuleDTO toDTO(Module module);
    Module toEntity(ModuleDTO moduleDTO);
    List<ModuleDTO> toDTO(List<Module> modules);
    List<Module> toEntity(List<ModuleDTO> moduleDTOs);
    ModuleShortDTO toShortDTO(Module module);
}

package kz.alan.roadmapapi.mappers;

import kz.alan.roadmapapi.model.dtos.RoadmapDTO;
import kz.alan.roadmapapi.model.dtos.shorts.RoadmapShortDTO;
import kz.alan.roadmapapi.model.entities.Roadmap;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoadmapMapper {
    RoadmapMapper INSTANCE = Mappers.getMapper(RoadmapMapper.class);
    RoadmapDTO toDTO(Roadmap roadmap);
    Roadmap toEntity(RoadmapDTO roadmapDTO);
    List<RoadmapDTO> toDTO(List<Roadmap> roadmap);
    List<Roadmap> toEntity(List<RoadmapDTO> roadmapDTO);
    RoadmapShortDTO toShortDTO(Roadmap roadmap);
}

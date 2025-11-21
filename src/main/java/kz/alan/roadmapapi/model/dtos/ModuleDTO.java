package kz.alan.roadmapapi.model.dtos;

import kz.alan.roadmapapi.model.dtos.shorts.ModuleShortDTO;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDTO {
    private Long id;

    private String name;
    private String description;

    private RoadmapDTO roadmap;

    private Set<ModuleShortDTO> previousModules;

    private Set<ModuleShortDTO> nextModules;
}

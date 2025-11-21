package kz.alan.roadmapapi.model.dtos.shorts;

import kz.alan.roadmapapi.model.dtos.RoadmapDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleShortDTO {
    private Long id;

    private String name;
    private String description;
}

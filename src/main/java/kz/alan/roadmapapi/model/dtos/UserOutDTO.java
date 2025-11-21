package kz.alan.roadmapapi.model.dtos;

import kz.alan.roadmapapi.model.dtos.shorts.ModuleShortDTO;
import kz.alan.roadmapapi.model.dtos.shorts.RoadmapShortDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOutDTO {
    private Long id;

    private String username;

    private List<RoadmapShortDTO> roadmaps;
    private List<ModuleShortDTO> modules;
}

package kz.alan.roadmapapi.model.dtos;

import kz.alan.roadmapapi.model.dtos.shorts.ModuleShortDTO;
import kz.alan.roadmapapi.model.dtos.shorts.UserShortDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapDTO {
    private Long id;

    private String name;
    private String description;

    private List<ModuleShortDTO> modules;
    private List<UserShortDTO> users;
}

package kz.alan.roadmapapi.model.dtos;

import kz.alan.roadmapapi.model.dtos.shorts.ModuleShortDTO;
import kz.alan.roadmapapi.model.dtos.shorts.RoadmapShortDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String username;
    private String password;
    private String email;

    private List<RoadmapShortDTO> roadmaps;
    private List<ModuleShortDTO> modules;
}

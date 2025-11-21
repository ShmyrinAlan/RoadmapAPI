package kz.alan.roadmapapi.model.dtos.shorts;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoadmapShortDTO {
    private Long id;

    private String name;
    private String description;
}

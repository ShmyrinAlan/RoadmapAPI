package kz.alan.roadmapapi.model.dtos.shorts;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserShortDTO {
    private Long id;

    private String username;
}

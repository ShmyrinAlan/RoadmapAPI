package kz.alan.roadmapapi.model.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInDTO {
    private Long id;

    private String username;
    private String password;
    private String email;
}

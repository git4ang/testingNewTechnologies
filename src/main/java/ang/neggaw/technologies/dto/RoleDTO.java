package ang.neggaw.technologies.dto;

import lombok.*;

/**
 * author by: ANG
 * since: 24/10/2022 14:56
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder @ToString
public class RoleDTO {
    private String roleId;
    private String roleName;
    private long userId;
}

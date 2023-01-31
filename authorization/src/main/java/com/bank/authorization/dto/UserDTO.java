package com.bank.authorization.dto;

import com.bank.authorization.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Set<Role> role;

    @NotNull
    private Long profileId;

    @NotNull
    private String password;
}

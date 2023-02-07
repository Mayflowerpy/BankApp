package com.bank.authorization.dto;

import com.bank.authorization.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * Трансферный слой dto для сущности user
 * За основу взяты все поля кроме id
 *
 * @author Vladislav Shilov
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private Long id;
    @NotNull
    @NotEmpty(message = "Role should not be empty")
    private Set<Role> role;

    @NotNull
    @NotEmpty(message = "ProfileId should not be empty")
    private Long profileId;

    @NotNull
    @NotEmpty(message = "Password should not be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{5,}$",
            message = "The string must be at least 5 characters long, contain at least 1 uppercase letter, " +
                    "1 lowercase letter, and OR special character(@#$%) OR number.")
    private String password;
}

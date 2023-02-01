package com.bank.authorization.mapper;

import com.bank.authorization.dto.UserDTO;
import com.bank.authorization.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Маппер Mapstruct для сущности User
 * toUser - преобразует UserDTO в User
 * toUserDTO - преобразует User в UserDTO
 * Бизнес-логика преобразования реализуется в RestController
 *
 * @author Vladislav Shilov
 */

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}

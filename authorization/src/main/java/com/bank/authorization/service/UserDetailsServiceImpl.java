package com.bank.authorization.service;

import com.bank.authorization.entity.User;
import com.bank.authorization.pojos.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Класс необходимый для аутентификации и авторизации в приложении
 *
 * @author Vladislav Shilov
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final ProfileFeignService profileFeignService;
    @Autowired
    public UserDetailsServiceImpl(UserService userService, ProfileFeignService profileFeignService) {
        this.userService = userService;
        this.profileFeignService = profileFeignService;
    }

    /**
     * Метод loadUserByUsername(String username) - подгружает пользователя из базы данных по полю Username
     * В случае если пользователь отсутствует - выбрасывает исключение UsernameNotFoundException
     * Загрузка email происходит путем получения его из микросервиса profile с помощью FeignClient и ProfileFeignServiceImpl
     * Загрузка password и roles происходит из базы данных данного микросервиса
     * Сопоставление email и password происходит по полю profileId сущности User
     *
     * @return возвращает объект UserDetails, включающий username, password, roles(authorities)
     * @author Vladislav Shilov
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Profile> profile = profileFeignService.getProfileByUsername(username);
        if (profile.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with mail %s not found", username));
        } else {
            User user = userService.getByProfileId(profile.get().getId());
            return new org.springframework.security.core.userdetails.User(profile.get().getEmail(), user.getPassword(), user.getAuthorities());
        }
    }
}

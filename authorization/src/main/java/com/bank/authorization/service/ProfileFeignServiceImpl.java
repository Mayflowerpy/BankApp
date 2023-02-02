package com.bank.authorization.service;

import com.bank.authorization.controllers.UserRestController;
import com.bank.authorization.pojos.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой бизнес-логики для получения сущности Profile из микросервиса profile
 * Реализует методы интерфейса ProfileFeignService
 * getProfileByUsername(username) - метод представляет собой получение списка профилей из микросервиса profile посредством
 * FeignClient и дальнейший поиск объекта Profile по переданному username
 * Возвращает Optional<Profile>
 *
 * @author Vladislav Shilov
 */

@Service
@Transactional(readOnly = true)
public class ProfileFeignServiceImpl implements ProfileFeignService{
    private final UserRestController userRestController;

    @Autowired
    public ProfileFeignServiceImpl(UserRestController userRestController) {
        this.userRestController = userRestController;
    }

    @Override
    public Optional<Profile> getProfileByUsername(String username) {
        List<Profile> profiles = userRestController.getProfiles();
        return profiles.stream()
                .filter(obj -> ((obj.getEmail().equals(username))))
                .findFirst();
    }
}

package com.bank.authorization.service;

import com.bank.authorization.pojos.Profile;
import java.util.Optional;

/**
 * Сервисный интерфейс бизнес-логики для получения сущности Profile из микросервиса profile
 * Реализация в классе ProfileFeignServiceImpl
 *
 * @author Vladislav Shilov
 */

public interface ProfileFeignService {
    Optional<Profile> getProfileByUsername(String username);
}

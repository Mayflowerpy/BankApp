package com.bank.authorization.feign;

import com.bank.authorization.pojos.Profile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/**
 * FeignClient для обращения к микросервису Profile
 * Метод getProfileByUsername(username) возвращает профиль из базы данных микросервиса profile по полю email
 * ВАЖНО: для работы метода необходимо наличие у profile REST-метода(GET) по url "//localhost:8089/api/profile"
 * с возвращением профиля по передаваемому(@RequestParam) полю - email
 *
 * @author Vladislav Shilov
 */

@FeignClient(value = "profileFeign", url = "http://localhost:8089/api/profile")
public interface ProfileFeignClient {
    @GetMapping
    Optional<Profile> getProfileByUsername(@RequestParam(value = "username") String username);
}

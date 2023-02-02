package com.bank.authorization.feign;

import com.bank.authorization.pojos.Profile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * FeignClient для обращения к микросервису Profile
 * Метод showAllUsers() возвращает список профилей из базы данных микросервиса profile
 * ВАЖНО: для работы метода необходимо наличие у profile REST-метода(GET) по url "//localhost:8089/api/profile/profiles"
 *
 * @author Vladislav Shilov
 */

@FeignClient(value = "profileFeign", url = "http://localhost:8089/api/profile")
public interface ProfileFeignClient {
    @GetMapping("/profiles")
    List<Profile> showAllUsers();
}

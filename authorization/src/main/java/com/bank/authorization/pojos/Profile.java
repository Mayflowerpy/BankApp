package com.bank.authorization.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * POJO класс для получения объекта Profile из JSON полученного из микросервиса profile
 *
 * @author Vladislav Shilov
 */
@Getter
@Setter
@Builder
public class Profile {
    private Long id;
    private Long phoneNumber;
    private String email;
    private String nameOnCard;
    private Long inn;
    private Long snils;
    private Long passportId;
    private Long actualRegistrationId;
}

package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetails;
import lombok.*;

import javax.validation.constraints.*;

/**
 * BankDetailsDto - объект передачи данных сущности BankDetails (банковские реквизиты).
 * <b>bik</b> - БИК (банковский идентификационный счет). Обязательное поле
 * <b>inn</b> - ИНН (идентификационный номер налогоплательщика). Обязательное поле
 * <b>kpp</b> - КПП (Код причины постановки на учет). Обязательное поле
 * <b>corAccount</b> - корреспондентский счет. Обязательное поле
 * <b>city</b> - город регистрации юридического адреса банка. Обязательное поле
 * <b>jointStockCompany</b> - акционерное общество. Обязательное поле
 * <b>name</b> - Имя банка. Обязательное поле
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see BankDetails
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BankDetailsDto {

    @NotEmpty(message = "Id should not be empty")
    @Min(value = 1, message = "Id should be greater than 0")
    private Long id;

    @NonNull
    @NotEmpty(message = "BIK should not be empty")
    @Min(value = 100_000_000L, message = "BIK should be 9 characters long")
    @Max(value = 999_999_999L, message = "BIK should be 9 characters long")
    private Long bik;

    @NonNull
    @NotEmpty(message = "INN should not be empty")
    @Min(value = 1_000_000_000L, message = "INN should be greater than 10 characters")
    @Max(value = 999_999_999_999L, message = "BIK should be less than 12 characters")
    private Long inn;

    @NonNull
    @NotEmpty(message = "KPP should not be empty")
    @Min(value = 1_000_000_000L, message = "INN should be greater than 10 characters")
    @Max(value = 999_999_999_999L, message = "BIK should be less than 12 characters")
    private Long kpp;

    @NonNull
    @NotEmpty(message = "Correspondent account should not be empty")
    @Min(value = 1_000_000_000, message = "BIK should be 11 characters long")
    @Max(value = 2_147_483_647, message = "BIK should be 11 characters long")
    private Integer corAccount;
    //Корреспондентский счет длиной в 20 символов, в Integer не влезет

    @NonNull
    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 180, message = "City should be between 2 and 180 characters")
    private String city;

    @NonNull
    @NotEmpty(message = "Joint stock company should not be empty")
    @Size(min = 2, max = 15, message = "Joint stock company should be between 2 and 15 characters")
    private String jointStockCompany;

    @NonNull
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 80, message = "Name should be between 2 and 80 characters")
    private String name;
}
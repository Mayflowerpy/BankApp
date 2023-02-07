package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.entity.License;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


/**
 * LicenseDto - объект передачи данных сущности License (лизенция банка).
 * <b>photo</b> - фотография лицензии. Обязательное поле.
 * <b>bankDetailsId</b> - ссылка на реквизиты банка. Внешний ключ,
 * ссылается на таблицу bank_details. Обязательное поле
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see License
 * @see BankDetails
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDto {

    @NotEmpty(message = "Id should not be empty")
    @Min(value = 1, message = "Id should be greater than 0")
    private Long id;

    @NotEmpty(message = "License photo should not be empty")
    private Byte[] photo;

    @NotEmpty(message = "Bank details should not be empty")
    private BankDetails bankDetails;
}

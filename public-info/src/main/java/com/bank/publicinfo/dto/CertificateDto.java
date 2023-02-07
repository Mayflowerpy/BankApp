package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.entity.Certificate;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * CertificateDto - объект передачи данных сущности Certificate (сертификат банка).
 * <b>photo</b> - фотография сертификата. Обязательное поле.
 * <b>bankDetailsId</b> - ссылка на реквизиты банка. Внешний ключ,
 * ссылается на таблицу bank_details. Обязательное поле
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see Certificate
 * @see BankDetails
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDto {

    @NotEmpty(message = "Id should not be empty")
    @Min(value = 1, message = "Id should be greater than 0")
    private Long id;

    @NotEmpty(message = "License photo should not be empty")
    private Byte[] photo;

    @NotEmpty(message = "Bank details should not be empty")
    private BankDetails bankDetails;
}

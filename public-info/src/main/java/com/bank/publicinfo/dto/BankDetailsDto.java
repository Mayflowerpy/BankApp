package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetails;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
@AllArgsConstructor
public class BankDetailsDto {

    @NotEmpty(message = "Id should not be empty")
    @Min(value = 1, message = "Id should be greater than 0")
    private Long id;

    @NotEmpty(message = "BIK should not be empty")
    @Size(min = 9, max = 9)
    private Long bik;

    @NotEmpty(message = "INN should not be empty")
    @Size(min = 10, max = 12)
    private Long inn;

    @NotEmpty(message = "KPP should not be empty")
    @Size(min = 10, max = 12)
    private Long kpp;

    @NotEmpty(message = "Correspondent account should not be empty")
    @Size(min = 20, max = 20)
    private Integer corAccount;

    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 180, message = "City should be between 2 and 180 characters")
    private String city;

    @NotEmpty(message = "Joint stock company should not be empty")
    @Size(min = 2, max = 15, message = "Joint stock company should be between 2 and 15 characters")
    private String jointStockCompany;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 80, message = "Name should be between 2 and 80 characters")
    private String name;
}

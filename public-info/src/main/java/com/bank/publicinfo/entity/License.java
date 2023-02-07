package com.bank.publicinfo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Сущность License - лицензия банка.
 * <b>photo</b> - фотография лицензии. Обязательное поле.
 * <b>bankDetailsId</b> - ссылка на реквизиты банка. Внешний ключ,
 * ссылается на таблицу bank_details. Обязательное поле
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see BankDetails
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "license", schema = "public_bank_information")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(name = "photo")
    private Byte[] photo;

    @NonNull
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private BankDetails bankDetails;
}

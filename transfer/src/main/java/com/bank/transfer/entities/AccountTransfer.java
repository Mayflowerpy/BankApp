package com.bank.transfer.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Класс переводов на банковский счет
 * Поля:
 * accountNumber - номер счета получателя
 */
@Entity
@Table(name = "account_transfer")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
public class AccountTransfer extends AbstractTransfer {
    @Column(name = "account_number")
    @NotNull(message = "Account number shouldn't be null")
    @Positive(message = "Account number shouldn't be negative")
    private Long accountNumber;
}

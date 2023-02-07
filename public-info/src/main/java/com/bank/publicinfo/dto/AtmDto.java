package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.entity.Branch;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Time;

/**
 * AtmDto - объект передачи данных сущности Atm (банковские реквизиты).
 * <b>address</b> - адрес банкомата, например, "ул. Пупкина, д.2". Обязательное поле
 * <b>startOfWork</b> - время начала работы банкомата, например, "4:00". Может быть пустым
 * <b>endOfWork</b> - время окончания работы банкомата, например, "00:00". Может быть пустым
 * <b>allHours</b> - является ли банкомат круглосуточным. Обязательное поле
 * <b>branch</b> - отделение банка, где расположен банкомат. Внешний ключ, ссылается
 * на таблицу <b>branch</b>. Может быть пустым
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see Branch
 * @see Atm
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtmDto {

    @NotEmpty(message = "Id should not be empty")
    @Min(value = 1, message = "Id should be greater than 0")
    private Long id;

    @NotEmpty(message = "Address should not be empty")
    @Size(min = 2, max = 370, message = "Address should be between 2 and 370 characters")
    private String address;

    private Time startOfWork;

    private Time endOfWork;

    @NotEmpty(message = "All hours should not be empty")
    private Boolean allHours;

    private Branch branch;
}

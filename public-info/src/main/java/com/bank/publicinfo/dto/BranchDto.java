package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.Branch;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

/**
 * BranchDto - объект передачи данных сущности Branch (отделение банка).
 * <b>address</b> - адрес отделения. Обязательное поле
 * <b>phoneNumber</b> - номер телефона отделения. Обязательное поле
 * <b>city</b> - город расположения отделения. Обязательное поле
 * <b>startOfWork</b> - время начала работы отделения. Обязательное поле
 * <b>endOfWork</b> - время окончания работы отделения. Обязательное поле
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see Branch
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BranchDto {

    @NotNull(message = "Id should not be null")
    @Min(value = 1, message = "Id should be greater than 0")
    private Long id;

    @NonNull
    @NotEmpty(message = "Address should not be empty")
    @Size(min = 2, max = 370, message = "Address must contain between 2 and 370 characters")
    private String address;

    @NonNull
    @NotNull(message = "Phone number should not be null")
    @Min(value = 10_000L, message = "Phone number must contain between 5 and 11 numbers")
    @Max(value = 99_999_999_999L, message = "Phone number must contain between 5 and 11 numbers")
    private Long phoneNumber;

    @NonNull
    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 250, message = "City must contain between 2 and 250 characters")
    private String city;

    @NonNull
    @NotNull(message = "Start of work should not be null")
    private Time startOfWork;

    @NonNull
    @NotNull(message = "End of work should not be null")
    private Time endOfWork;
}

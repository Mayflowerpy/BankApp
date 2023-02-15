package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.Branch;
import lombok.*;

import javax.validation.constraints.*;
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
    @Size(min = 2, max = 370, message = "Address should be between 2 and 370 characters")
    private String address;

    @NonNull
    @NotNull(message = "Phone number should not be null")
    @Min(value = 10_000L, message = "Phone number should be more than 5 characters")
    @Max(value = 99_999_999_999L, message = "Phone number should be less than 11 characters")
    private Long phoneNumber;

    @NonNull
    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 250, message = "City should be between 2 and 250 characters")
    private String city;

    @NonNull
    @NotNull(message = "Start of work should not be null")
    private Time startOfWork;

    @NonNull
    @NotNull(message = "End of work should not be null")
    private Time endOfWork;
}

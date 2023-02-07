package com.bank.publicinfo.dto;


import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.entity.EntityType;
import com.bank.publicinfo.entity.OperationType;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * AuditDto - объект передачи данных сущности Audit (аудит).
 * <b>entityType</b> - тип сущности. Обязательное поле
 * <b>operationType</b> - тип операции. Обязательное поле
 * <b>createdBy</b> - создатель сущности. Обязательное поле
 * <b>modifiedBy</b> - кто изменил сущность. Может быть пустым
 * <b>createdAt</b> - время создания сущности относительно временной зоны. Обязательное поле
 * <b>modified_at</b> - время изменения сущности относительно временной зоны. Может быть пустым
 * <b>newEntityJson</b> - JSON, заполняется при изменении сущности. Для хранения в БД преобразуется
 * к текстовому представлению. Может быть пустым
 * <b>entityJson</b> - JSON, заполняется при изменении и сохранении сущности. Для хранения в БД
 * преобразуется к текстовому представлению. Обязательное поле
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see Audit
 * @see EntityType
 * @see OperationType
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDto {

    @NotEmpty(message = "Id should not be empty")
    @Min(value = 1, message = "Id should be greater than 0")
    private Long id;

    @NotEmpty(message = "Entity type should not be empty")
    @Size(min = 2, max = 40, message = "Address should be between 2 and 40 characters")
    private EntityType entityType;

    @NotEmpty(message = "Operation type should not be empty")
    @Size(min = 2, max = 255, message = "Address should be between 2 and 255 characters")
    private OperationType operationType;

    @NotEmpty(message = "This string should not be empty")
    @Size(min = 2, max = 255, message = "This string should be between 2 and 255 characters")
    private String createdBy;

    private String modifiedBy;

    @NotEmpty(message = "Time of creation should not be empty")
    private Timestamp createdAt;

    private Timestamp modifiedAt;

    private String newEntityJson;

    @NotEmpty(message = "Entity should not be empty")
    private String entityJson;
}

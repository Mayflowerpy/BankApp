package com.bank.publicinfo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Сущность Audit - аудит.
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
 * @see EntityType
 * @see OperationType
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "audit", schema = "public_bank_information")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Size(max = 40)
    @Column(name = "entity_type")
    private EntityType entityType;

    @NonNull
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Size(max = 255)
    @Column(name = "operation_type")
    private OperationType operationType;

    @NonNull
    @NotEmpty
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;

    @Size(max = 255)
    @Column(name = "modified_by")
    private String modifiedBy;

    @NonNull
    @NotNull
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @NonNull
    @NotEmpty
    @Column(name = "entity_json")
    private String entityJson;
}

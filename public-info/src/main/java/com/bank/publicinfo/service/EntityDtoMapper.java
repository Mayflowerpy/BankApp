package com.bank.publicinfo.service;

import java.util.Collection;
import java.util.List;

/**
 * Интерфейс EntityDtoMapper<E, D> - маппер для преобразования Entity из/в Dto
 *
 * @param <E> - Entity.class
 * @param <D> - EntityDto.class
 * @author UnsleepingOwl (Lev Yakolin)
 */

public interface EntityDtoMapper<E, D> {

    /**
     * Преобразует DTO в Entity указанного класса
     *
     * @param dto             - объект передачи данных
     * @param entityClassName - имя класса сущности
     * @return E - объект Entity указанного класса
     */
    E toEntity(D dto, String entityClassName);

    /**
     * Преобразует Entity в DTO указанного класса
     *
     * @param entity       - объект сущности
     * @param dtoClassName - имя класса объекта передачи данных
     * @return D - объект передачи данных указанного класса
     */
    D toDto(E entity, String dtoClassName);

    /**
     * Преобразует Collection Entity в List DTO указанного класса
     *
     * @param entityCollection - коллекция объектов сущности
     * @param dtoClassName     - имя класса объекта передачи данных
     * @return List<D> - List объектов передачи данных указанного класса
     */
    List<D> toDtoList(Collection<E> entityCollection, String dtoClassName);
}

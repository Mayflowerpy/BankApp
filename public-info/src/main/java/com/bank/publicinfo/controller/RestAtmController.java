package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.service.AtmService;
import com.bank.publicinfo.service.EntityDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST-контроллер RestAtmController. Сущность - Atm (банкомат).
 * <b>ENTITY_CLASS_NAME</b> - имя класса сущности
 * <b>DTO_CLASS_NAME</b> - имя класса объекта передачи данных
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see BasicRestController
 * @see Atm
 * @see AtmDto
 * @see AtmService
 * @see EntityDtoMapper
 */

@Slf4j
@RestController
@RequestMapping
public class RestAtmController implements BasicRestController<AtmDto> {

    private final AtmService service;
    private final EntityDtoMapper<Atm, AtmDto> mapper;

    private final String ENTITY_CLASS_NAME = "com.bank.publicinfo.entity.Atm";
    private final String DTO_CLASS_NAME = "com.bank.publicinfo.dto.AtmDto";

    public RestAtmController(AtmService service, EntityDtoMapper<Atm, AtmDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/atm/all")
    @Override
    public ResponseEntity<List<AtmDto>> getList() {
        log.info("Вызов метода getList() в контроллере " + this.getClass());
        return new ResponseEntity<>(mapper.toDtoList(service.findAll(), DTO_CLASS_NAME), HttpStatus.OK);
    }

    @GetMapping(value = "/atm/id={id}")
    public ResponseEntity<AtmDto> getById(@PathVariable("id") Long id) {
        log.info("Вызов метода getById() |id = " + id + "| в контроллере " + this.getClass());
        return new ResponseEntity<>(mapper.toDto(service.findById(id), DTO_CLASS_NAME), HttpStatus.FOUND);
    }

    @PostMapping(value = "/admin/atm/new")
    @Override
    public ResponseEntity<AtmDto> create(@RequestBody @Valid AtmDto dto) {
        log.info("Вызов метода create() |DTO = " + dto + "| в контроллере " + this.getClass());
        service.save(mapper.toEntity(dto, ENTITY_CLASS_NAME));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/admin/atm/edit")
    @Override
    public ResponseEntity<AtmDto> update(@RequestBody @Valid AtmDto dto) {
        log.info("Вызов метода update() |DTO = " + dto + "| в контроллере " + this.getClass());
        service.save(mapper.toEntity(dto, ENTITY_CLASS_NAME));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/admin/atm/id={id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        log.info("Вызов метода deleteById() |id = " + id + "| в контроллере " + this.getClass());
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

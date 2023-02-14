package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.service.BankDetailsService;
import com.bank.publicinfo.service.EntityDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST-контроллер RestBankDetailsController. Сущность - BankDetails (банковские реквизиты).
 * <b>ENTITY_CLASS_NAME</b> - имя класса сущности
 * <b>DTO_CLASS_NAME</b> - имя класса объекта передачи данных
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see BasicRestController
 * @see BankDetails
 * @see BankDetailsDto
 * @see BankDetailsService
 * @see EntityDtoMapper
 */

@Slf4j
@RestController
@RequestMapping
public class RestBankDetailsController implements BasicRestController<BankDetailsDto> {

    private final BankDetailsService service;
    private final EntityDtoMapper<BankDetails, BankDetailsDto> mapper;

    private final String ENTITY_CLASS_NAME = BankDetails.class.getCanonicalName();
    private final String DTO_CLASS_NAME = BankDetailsDto.class.getCanonicalName();

    public RestBankDetailsController(BankDetailsService service, EntityDtoMapper<BankDetails, BankDetailsDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/bank-details/all")
    @Override
    public ResponseEntity<List<BankDetailsDto>> getList() {
        log.info("Вызов метода getList() в контроллере " + this.getClass());
        return new ResponseEntity<>(mapper.toDtoList(service.findAll(), DTO_CLASS_NAME), HttpStatus.OK);
    }

    @GetMapping(value = "/bank-details/id={id}")
    @Override
    public ResponseEntity<BankDetailsDto> getById(@PathVariable("id") Long id) {
        log.info("Вызов метода getById() |id = " + id + "| в контроллере " + this.getClass());
        return new ResponseEntity<>(mapper.toDto(service.findById(id), DTO_CLASS_NAME), HttpStatus.OK);
    }

    @PostMapping(value = "/admin/bank-details/new")
    @Override
    public ResponseEntity<BankDetailsDto> create(@RequestBody @Valid BankDetailsDto dto) {
        log.info("Вызов метода create() |DTO = " + dto + "| в контроллере " + this.getClass());
        service.save(mapper.toEntity(dto, ENTITY_CLASS_NAME));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/admin/bank-details/edit")
    @Override
    public ResponseEntity<BankDetailsDto> update(@RequestBody @Valid BankDetailsDto dto) {
        log.info("Вызов метода update() |DTO = " + dto + "| в контроллере " + this.getClass());
        service.save(mapper.toEntity(dto, ENTITY_CLASS_NAME));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/admin/bank-details/id={id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        log.info("Вызов метода deleteById() |id = " + id + "| в контроллере " + this.getClass());
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
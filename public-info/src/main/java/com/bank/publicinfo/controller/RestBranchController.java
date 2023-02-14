package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.service.BranchService;
import com.bank.publicinfo.service.EntityDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST-контроллер RestBranchController. Сущность - Branch (отделение банка).
 * <b>ENTITY_CLASS_NAME</b> - имя класса сущности
 * <b>DTO_CLASS_NAME</b> - имя класса объекта передачи данных
 *
 * @author UnsleepingOwl (Lev Yakolin)
 * @see BasicRestController
 * @see Branch
 * @see BranchDto
 * @see BranchService
 * @see EntityDtoMapper
 */

@Slf4j
@RestController
@RequestMapping
public class RestBranchController implements BasicRestController<BranchDto> {

    private final BranchService service;
    private final EntityDtoMapper<Branch, BranchDto> mapper;

    private final String ENTITY_CLASS_NAME = Branch.class.getCanonicalName();
    private final String DTO_CLASS_NAME = BranchDto.class.getCanonicalName();

    public RestBranchController(BranchService service, EntityDtoMapper<Branch, BranchDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/branch/all")
    @Override
    public ResponseEntity<List<BranchDto>> getList() {
        log.info("Вызов метода getList() в контроллере " + this.getClass());
        return new ResponseEntity<>(mapper.toDtoList(service.findAll(), DTO_CLASS_NAME), HttpStatus.OK);
    }

    @GetMapping(value = "/branch/id={id}")
    @Override
    public ResponseEntity<BranchDto> getById(@PathVariable("id") Long id) {
        log.info("Вызов метода getById() |id = " + id + "| в контроллере " + this.getClass());
        return new ResponseEntity<>(mapper.toDto(service.findById(id), DTO_CLASS_NAME), HttpStatus.OK);
    }

    @PostMapping(value = "/admin/branch/new")
    @Override
    public ResponseEntity<BranchDto> create(@RequestBody @Valid BranchDto dto, BindingResult bindingResult) {
        log.info("Вызов метода create() |DTO = " + dto + "| в контроллере " + this.getClass());
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(bindingResult.getAllErrors().toString());
        }
        service.save(mapper.toEntity(dto, ENTITY_CLASS_NAME));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/admin/branch/edit")
    @Override
    public ResponseEntity<BranchDto> update(@RequestBody @Valid BranchDto dto, BindingResult bindingResult) {
        log.info("Вызов метода update() |DTO = " + dto + "| в контроллере " + this.getClass());
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(bindingResult.getAllErrors().toString());
        }
        service.save(mapper.toEntity(dto, ENTITY_CLASS_NAME));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/admin/branch/id={id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        log.info("Вызов метода deleteById() |id = " + id + "| в контроллере " + this.getClass());
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

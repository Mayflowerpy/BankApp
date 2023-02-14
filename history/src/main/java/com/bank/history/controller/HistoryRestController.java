package com.bank.history.controller;

import com.bank.history.entity.dto.HistoryDTO;
import com.bank.history.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * класс контроллера, принимает запросы и возвращает согласно запросу или данные, или делает обновление данных
 *
 * @author Larisa Ermakova
 */
@RestController
public class HistoryRestController {
    /**
     * работа класса с сервисным слоем
     */
    private final HistoryService historyService;

    /**
     * внедрение зависимости через конструктор
     */
    public HistoryRestController(HistoryService historyService) {
        this.historyService = historyService;
    }

    /**
     * GET запрос, настроенный по URI, выводит все записи historyDTO
     */
    @GetMapping(path = "/histories")
    public ResponseEntity<List<HistoryDTO>> getAllHistory() {
        return ResponseEntity.ok(historyService.getAllHistory());
    }

    /**
     * POST запрос с данными новой history добавит ее в БД (ДТО перейдет в entity)
     */
    @PostMapping(path = "/newHistory")
    public ResponseEntity<HistoryDTO> saveHistory(@RequestBody HistoryDTO historyDTO) {
        return ResponseEntity.ok(historyService.save(historyDTO));
    }

    /**
     * GET запрос для получения history по id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<HistoryDTO> findHistoryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(historyService.findById(id));
    }

    /**
     * запрос для изменения существующей записи history
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<HistoryDTO> updateHistory(@PathVariable("id") Long id, @RequestBody HistoryDTO historyDTO) {
        return ResponseEntity.ok(historyService.update(id, historyDTO));
    }
}

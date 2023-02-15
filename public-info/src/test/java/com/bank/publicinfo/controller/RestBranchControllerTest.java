package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.service.BranchService;
import com.bank.publicinfo.service.EntityDtoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestBranchController.class)
class RestBranchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BranchService mockService;

    @MockBean
    private EntityDtoMapper<Branch, BranchDto> mockMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String ENTITY_CLASS_NAME = Branch.class.getCanonicalName();
    private final String DTO_CLASS_NAME = BranchDto.class.getCanonicalName();

    private final Branch ENTITY = new Branch("address", 11_111L, "city", Time.valueOf(LocalTime.of(12, 0, 0)),
            Time.valueOf(LocalTime.of(12, 0, 0)));
    private final BranchDto DTO = new BranchDto("address", 11_111L, "city", Time.valueOf(LocalTime.of(12, 0, 0)),
            Time.valueOf(LocalTime.of(12, 0, 0)));

    {
        ENTITY.setId(1L);
        DTO.setId(1L);
    }

    @Test
    @DisplayName("Возвращение списка DTO")
    void testGetList() throws Exception {

        final List<Branch> entityList = List.of(ENTITY);
        final List<BranchDto> dtoList = List.of(DTO);

        when(mockService.findAll()).thenReturn(entityList);
        when(mockMapper.toDtoList(entityList, DTO_CLASS_NAME)).thenReturn(dtoList);

        final MockHttpServletResponse response = mockMvc
                .perform(get("/branch/all").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(objectMapper.writeValueAsString(dtoList));
    }

    @Test
    @DisplayName("Возвращение пустого списка DTO, если список Entity пуст")
    void testGetEmptyList() throws Exception {

        when(mockService.findAll()).thenReturn(Collections.emptyList());
        when(mockMapper.toDtoList(Collections.emptyList(), DTO_CLASS_NAME)).thenReturn(Collections.emptyList());

        final MockHttpServletResponse response = mockMvc
                .perform(get("/branch/all").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    @DisplayName("Возвращение списка DTO, а не Entity")
    void testEntityDtoMapperReturnsNoItems() throws Exception {

        final List<Branch> entityList = List.of(ENTITY);

        when(mockService.findAll()).thenReturn(entityList);
        when(mockMapper.toDtoList(entityList, DTO_CLASS_NAME)).thenReturn(Collections.emptyList());

        final MockHttpServletResponse response = mockMvc
                .perform(get("/branch/all").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(objectMapper.writeValueAsString(Collections.emptyList()));
    }

    @Test
    @DisplayName("Возвращение DTO по ID")
    void testGetById() throws Exception {

        when(mockService.findById(1L)).thenReturn(ENTITY);
        when(mockMapper.toDto(ENTITY, DTO_CLASS_NAME)).thenReturn(DTO);

        final MockHttpServletResponse response = mockMvc
                .perform(get("/branch/id={id}", 1).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(objectMapper.writeValueAsString(DTO));
    }

    @Test
    @DisplayName("Сохранение сущности")
    void testCreate() throws Exception {

        when(mockMapper.toEntity(DTO, ENTITY_CLASS_NAME)).thenReturn(ENTITY);

        final MockHttpServletResponse response = mockMvc.perform(post("/admin/branch/new")
                        .content(objectMapper.writeValueAsString(DTO)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(objectMapper.writeValueAsString(DTO));
        verify(mockService).save(ENTITY);
    }

    @Test
    @DisplayName("Обновление сущности")
    void testUpdate() throws Exception {

        when(mockMapper.toEntity(DTO, ENTITY_CLASS_NAME)).thenReturn(ENTITY);

        final MockHttpServletResponse response = mockMvc.perform(patch("/admin/branch/edit")
                        .content(objectMapper.writeValueAsString(DTO)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(objectMapper.writeValueAsString(DTO));
        verify(mockService).save(ENTITY);
    }

    @Test
    @DisplayName("Удаление сущности по ID")
    void testDeleteById() throws Exception {

        final MockHttpServletResponse response = mockMvc.perform(delete("/admin/branch/id={id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("");
        verify(mockService).delete(1L);
    }
}

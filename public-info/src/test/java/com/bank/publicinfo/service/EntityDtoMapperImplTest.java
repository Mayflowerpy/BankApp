package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.*;
import com.bank.publicinfo.entity.*;
import org.junit.jupiter.api.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("mapper")
@SuppressWarnings("FieldCanBeLocal")
class EntityDtoMapperImplTest {

    @Nested
    @DisplayName("Преобразование Atm и AtmDto")
    @Tag("atm_atmDto")
    class AtmMapperTest {

        private final EntityDtoMapper<Atm, AtmDto> mapper = new EntityDtoMapperImpl<>();

        private final String ENTITY_CLASS_NAME = "com.bank.publicinfo.entity.Atm";
        private final String DTO_CLASS_NAME = "com.bank.publicinfo.dto.AtmDto";

        private final Atm ENTITY = new Atm("address", false);
        private final AtmDto DTO = new AtmDto("address", false);

        @Test
        @DisplayName("Преобразование DTO в Entity")
        void testToEntity() {
            genericTestToEntity(mapper, DTO, ENTITY_CLASS_NAME, ENTITY);
        }

        @Test
        @DisplayName("Преобразование Entity в DTO")
        void testToDto() {
            genericTestToDto(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }

        @Test
        @DisplayName("Преобразование списка Entity в список DTO")
        void testToDtoList() {
            genericTestToDtoList(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }
    }

    @Nested
    @DisplayName("Преобразование Audit и AuditDto")
    @Tag("audit_auditDto")
    class AuditMapperTest {

        private final EntityDtoMapper<Audit, AuditDto> mapper = new EntityDtoMapperImpl<>();

        private final String ENTITY_CLASS_NAME = "com.bank.publicinfo.entity.Audit";
        private final String DTO_CLASS_NAME = "com.bank.publicinfo.dto.AuditDto";

        private final Audit ENTITY = new Audit(EntityType.ENTITY_TYPE_ONE, OperationType.OPERATION_TYPE_ONE, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "entityJson");
        private final AuditDto DTO = new AuditDto(EntityType.ENTITY_TYPE_ONE, OperationType.OPERATION_TYPE_ONE, "createdBy",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), "entityJson");


        @Test
        @DisplayName("Преобразование DTO в Entity")
        void testToEntity() {
            genericTestToEntity(mapper, DTO, ENTITY_CLASS_NAME, ENTITY);
        }

        @Test
        @DisplayName("Преобразование Entity в DTO")
        void testToDto() {
            genericTestToDto(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }

        @Test
        @DisplayName("Преобразование списка Entity в список DTO")
        void testToDtoList() {
            genericTestToDtoList(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }
    }

    @Nested
    @DisplayName("Преобразование BankDetails и BankDetailsDto")
    @Tag("bankDetails_bankDetailsDto")
    class BankDetailsMapperTest {

        private final EntityDtoMapper<BankDetails, BankDetailsDto> mapper = new EntityDtoMapperImpl<>();

        private final String ENTITY_CLASS_NAME = "com.bank.publicinfo.entity.BankDetails";
        private final String DTO_CLASS_NAME = "com.bank.publicinfo.dto.BankDetailsDto";

        private final BankDetails ENTITY = new BankDetails(1L, 0L, 0L, 0, "city", "jointStockCompany", "name");
        private final BankDetailsDto DTO = new BankDetailsDto(1L, 0L, 0L, 0, "city", "jointStockCompany", "name");


        @Test
        @DisplayName("Преобразование DTO в Entity")
        void testToEntity() {
            genericTestToEntity(mapper, DTO, ENTITY_CLASS_NAME, ENTITY);
        }

        @Test
        @DisplayName("Преобразование Entity в DTO")
        void testToDto() {
            genericTestToDto(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }

        @Test
        @DisplayName("Преобразование списка Entity в список DTO")
        void testToDtoList() {
            genericTestToDtoList(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }
    }

    @Nested
    @DisplayName("Преобразование Branch и BranchDto")
    @Tag("branch_branchDto")
    class BranchMapperTest {

        private final EntityDtoMapper<Branch, BranchDto> mapper = new EntityDtoMapperImpl<>();

        private final String ENTITY_CLASS_NAME = "com.bank.publicinfo.entity.Branch";
        private final String DTO_CLASS_NAME = "com.bank.publicinfo.dto.BranchDto";

        private final Branch ENTITY = new Branch("address", 0L, "city", Time.valueOf(LocalTime.of(12, 0, 0)),
                Time.valueOf(LocalTime.of(12, 0, 0)));
        private final BranchDto DTO = new BranchDto("address", 0L, "city", Time.valueOf(LocalTime.of(12, 0, 0)),
                Time.valueOf(LocalTime.of(12, 0, 0)));

        @Test
        @DisplayName("Преобразование DTO в Entity")

        void testToEntity() {
            genericTestToEntity(mapper, DTO, ENTITY_CLASS_NAME, ENTITY);
        }

        @Test
        @DisplayName("Преобразование Entity в DTO")
        void testToDto() {
            genericTestToDto(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }

        @Test
        @DisplayName("Преобразование списка Entity в список DTO")
        void testToDtoList() {
            genericTestToDtoList(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }
    }

    @Nested
    @DisplayName("Преобразование Certificate и CertificateDto")
    @Tag("certificate_certificateDto")
    class CertificateMapperTest {

        private final EntityDtoMapper<Certificate, CertificateDto> mapper = new EntityDtoMapperImpl<>();

        private final String ENTITY_CLASS_NAME = "com.bank.publicinfo.entity.Certificate";
        private final String DTO_CLASS_NAME = "com.bank.publicinfo.dto.CertificateDto";

        private final BankDetails BANK_DETAILS = new BankDetails(0L, 0L, 0L, 0, "city", "jointStockCompany", "name");

        private final Certificate ENTITY = new Certificate(new Byte[]{(byte) 0b0}, BANK_DETAILS);
        private final CertificateDto DTO = new CertificateDto(new Byte[]{(byte) 0b0}, BANK_DETAILS);

        @Test
        @DisplayName("Преобразование DTO в Entity")
        void testToEntity() {
            genericTestToEntity(mapper, DTO, ENTITY_CLASS_NAME, ENTITY);
        }

        @Test
        @DisplayName("Преобразование Entity в DTO")
        void testToDto() {
            genericTestToDto(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }

        @Test
        @DisplayName("Преобразование списка Entity в список DTO")
        void testToDtoList() {
            genericTestToDtoList(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }
    }

    @Nested
    @DisplayName("Преобразование License и LicenseDto")
    @Tag("license_licenseDto")
    class LicenseMapperTest {

        private final EntityDtoMapper<License, LicenseDto> mapper = new EntityDtoMapperImpl<>();

        private final String ENTITY_CLASS_NAME = "com.bank.publicinfo.entity.License";
        private final String DTO_CLASS_NAME = "com.bank.publicinfo.dto.LicenseDto";

        private final BankDetails BANK_DETAILS = new BankDetails(0L, 0L, 0L, 0, "city", "jointStockCompany", "name");

        private final License ENTITY = new License(new Byte[]{(byte) 0b0}, BANK_DETAILS);
        private final LicenseDto DTO = new LicenseDto(new Byte[]{(byte) 0b0}, BANK_DETAILS);

        @Test
        @DisplayName("Преобразование DTO в Entity")
        void testToEntity() {
            genericTestToEntity(mapper, DTO, ENTITY_CLASS_NAME, ENTITY);
        }

        @Test
        @DisplayName("Преобразование Entity в DTO")
        void testToDto() {
            genericTestToDto(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }

        @Test
        @DisplayName("Преобразование списка Entity в список DTO")
        void testToDtoList() {
            genericTestToDtoList(mapper, ENTITY, DTO_CLASS_NAME, DTO);
        }
    }

    <E, D> void genericTestToEntity(EntityDtoMapper<E, D> mapper, D dto, String entityClassName, E entity) {
        assertThat(mapper.toEntity(dto, entityClassName)).isEqualTo(entity);
    }

    <E, D> void genericTestToDto(EntityDtoMapper<E, D> mapper, E entity, String dtoClassName, D dto) {
        assertThat(mapper.toDto(entity, dtoClassName)).isEqualTo(dto);
    }

    <E, D> void genericTestToDtoList(EntityDtoMapper<E, D> mapper, E entity, String dtoClassName, D dto) {
        assertThat(mapper.toDtoList(List.of(entity), dtoClassName))
                .isEqualTo(List.of(dto));
        assertThat(mapper.toDtoList(Collections.emptyList(), dtoClassName))
                .isEqualTo(Collections.emptyList());
    }
}

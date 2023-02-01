package com.bank.authorization.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

/**
 * Сущность Role - отвечает за предоставления прав доступа(authority) объектам User
 * Имплементирует GrantedAuthority
 * Роли являются перечислением и возможные роли берутся из EnumRole
 *
 * @author Vladislav Shilov
 */

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {
    public Role(RoleEnum name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", unique = true)
    @Enumerated(value=EnumType.STRING)
    @NotEmpty(message = "Role should not be empty")
    private RoleEnum name;

    @Override
    public String getAuthority() {
        return getName().name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.name();
    }
}

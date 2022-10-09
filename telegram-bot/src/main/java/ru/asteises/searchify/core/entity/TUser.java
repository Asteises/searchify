package ru.asteises.searchify.core.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class TUser {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "chat_id")
    private Long chatId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TUser tUser = (TUser) o;
        return id != null && Objects.equals(id, tUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package ru.asteises.searchify.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.searchify.core.entity.TUser;

import java.util.UUID;

@Repository
public interface UserStorage extends JpaRepository<TUser, UUID> {
}

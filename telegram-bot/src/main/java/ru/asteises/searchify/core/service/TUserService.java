package ru.asteises.searchify.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.searchify.core.entity.TUser;
import ru.asteises.searchify.core.repository.UserStorage;

@Service
@RequiredArgsConstructor
public class TUserService {

    private final UserStorage userStorage;

    public void createTUser(TUser tUser) {
        userStorage.save(tUser);
    }
}

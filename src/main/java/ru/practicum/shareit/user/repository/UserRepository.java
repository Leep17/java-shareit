package ru.practicum.shareit.user.repository;

import ru.practicum.shareit.user.User;
import java.util.Collection;

public interface UserRepository {

    Collection<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);
}

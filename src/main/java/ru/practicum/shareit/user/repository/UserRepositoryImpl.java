package ru.practicum.shareit.user.repository;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.user.User;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public Collection<User> findAll() {
        return users.values();
    }

    @Override
    public User findById(Long id) {
        if (users.get(id) == null) {
            throw  new NotFoundException("Пользователь с id=" + id + " не найден");
        }
        return users.get(id);
    }

    @Override
    public User save(User user) {
        user.setId(getNextId());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(Long id, User user) {
        User changedUser = findById(id);
        if (user.getName() != null) {
            changedUser.setName(user.getName());
        }

        if (user.getEmail() != null) {
            changedUser.setEmail(user.getEmail());
        }

        return changedUser;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        users.remove(id);
    }

    private long getNextId() {
        long currentMaxId = users.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
        }
}

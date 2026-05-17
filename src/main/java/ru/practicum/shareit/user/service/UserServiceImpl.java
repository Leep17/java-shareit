package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.ConflictException;
import ru.practicum.shareit.exception.ValidationException;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.repository.UserRepository;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new ValidationException("Email не может быть пустым");
        }

        if (!user.getEmail().contains("@")) {
            throw new ValidationException("Некорректный email");
        }

        boolean emailExists = userRepository.findAll().stream()
                .anyMatch(existingUser -> existingUser.getEmail().equals(user.getEmail()));

        if (emailExists) {
            throw new ConflictException("Email уже используется");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (user.getEmail() != null) {
            if (!user.getEmail().contains("@")) {
                throw new ValidationException("Некорректный email");
            }

            boolean emailExists = userRepository.findAll().stream()
                    .anyMatch(existingUser ->
                            existingUser.getEmail().equals(user.getEmail())
                                    && !existingUser.getId().equals(id)
                    );

            if (emailExists) {
                throw new ConflictException("Email уже используется");
            }
        }
        return userRepository.update(id, user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

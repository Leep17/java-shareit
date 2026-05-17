package ru.practicum.shareit.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO Sprint add-controllers.
 */
@Data
@EqualsAndHashCode(of = {"id"})
public class User {
    private Long id;
    private String name;
    private String email;

    public User() {
    }

    public User(Long id,
                String name,
                String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

package ru.practicum.shareit.item.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.practicum.shareit.request.ItemRequest;
import ru.practicum.shareit.user.User;

/**
 * TODO Sprint add-controllers.
 */
@Data
@EqualsAndHashCode(of = {"id"})
public class Item {

    private Long id;
    private String name;
    private String description;
    private Boolean Available;
    private User owner;
    private ItemRequest request;

    public Item() {

    }

    public Item(String name,
                String description,
                Boolean Available) {
        this.name = name;
        this.description = description;
        this.Available = Available;
    }
}

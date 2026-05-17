package ru.practicum.shareit.item.dto;

import lombok.Data;
/**
 * TODO Sprint add-controllers.
 */

@Data
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private Long idRequest;

    public ItemDto(Long id,
                   String name,
                   String description,
                   Boolean available,
                   Long idRequest) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.available = available;
        this.idRequest = idRequest;
    }
}

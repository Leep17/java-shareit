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
    private Boolean Available;
    private Long idRequest;

    public ItemDto(Long id,
                   String name,
                   String description,
                   Boolean Available,
                   Long idRequest) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.Available = Available;
        this.idRequest = idRequest;
    }
}

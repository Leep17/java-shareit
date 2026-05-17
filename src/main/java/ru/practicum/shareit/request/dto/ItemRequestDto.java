package ru.practicum.shareit.request.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * TODO Sprint add-item-requests.
 */
@Data
public class ItemRequestDto {
    private Long id;
    private String description;
    private Long idRequestor;
    private LocalDateTime created;

    public ItemRequestDto(Long id,
                          String description,
                          Long idRequestor,
                          LocalDateTime created) {
        this.id = id;
        this.description = description;
        this.idRequestor = idRequestor;
        this.created = created;
    }
}

package ru.practicum.shareit.booking.dto;

import lombok.Data;
import ru.practicum.shareit.booking.BookingStatus;
import java.time.LocalDateTime;

/**
 * TODO Sprint add-bookings.
 */
@Data
public class BookingDto {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long itemId;
    private Long idBooker;
    private BookingStatus status;

    public BookingDto(Long id,
                      LocalDateTime start,
                      LocalDateTime end,
                      Long itemId,
                      Long idBooker,
                      BookingStatus status) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.itemId = itemId;
        this.idBooker = idBooker;
        this.status = status;
    }
}

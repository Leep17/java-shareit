package ru.practicum.shareit.booking.mapper;

import ru.practicum.shareit.booking.Booking;
import ru.practicum.shareit.booking.dto.BookingDto;

public class BookingMapper {
    public static BookingDto toBookingDto(Booking booking) {
        return new BookingDto(booking.getId(),
                              booking.getStart(),
                              booking.getEnd(),
                              booking.getItem() != null ? booking.getItem().getId() : null,
                              booking.getBooker() != null ? booking.getBooker().getId() : null,
                              booking.getStatus()
        );
    }
}

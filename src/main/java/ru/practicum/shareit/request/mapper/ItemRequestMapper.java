package ru.practicum.shareit.request.mapper;

import ru.practicum.shareit.request.ItemRequest;
import ru.practicum.shareit.request.dto.ItemRequestDto;

public class ItemRequestMapper {
    public static ItemRequestDto toItemRequestDto(ItemRequest itemRequest){
        return new ItemRequestDto(itemRequest.getId(),
                                  itemRequest.getDescription(),
                                  itemRequest.getRequestor() != null
                                  ? itemRequest.getRequestor().getId() : null,
                                  itemRequest.getCreated());
    }
}

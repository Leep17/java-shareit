package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;

import java.util.Collection;

public interface ItemService {

    Item save(ItemDto itemDto, Long userId);

    Item update(ItemDto itemDto, Long userId, Long itemId);

    Item findById(Long id);

    Collection<Item> findAll(Long userId);

    Collection<Item> findByText(String description);
}

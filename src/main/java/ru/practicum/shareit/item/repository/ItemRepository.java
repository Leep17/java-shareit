package ru.practicum.shareit.item.repository;

import ru.practicum.shareit.item.model.Item;
import java.util.Collection;

public interface ItemRepository {

    Item save (Item item);

    Item update (Item item, Long itemId);

    Item findById (Long id);

    Collection<Item> findAll(Long userId);

    Collection<Item> findByText(String description);

}

package ru.practicum.shareit.item.repository;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.item.model.Item;

import java.util.*;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final Map<Long, Item> items = new HashMap<>();

    @Override
    public Item save(Item item) {
        item.setId(getNextId());
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public Item update(Item item, Long itemId) {
        Item changeItem = findById(itemId);

        if (item.getName() != null) {
            changeItem.setName(item.getName());
        }

        if (item.getDescription() != null) {
            changeItem.setDescription(item.getDescription());
        }

        if (item.getAvailable() != null) {
            changeItem.setAvailable(item.getAvailable());
        }
        return changeItem;
    }

    @Override
    public Item findById(Long id) {
        if (items.get(id) == null) {
            throw new NotFoundException("Предмет с id=" + id + " не найден");
        }
        return items.get(id);
    }

    @Override
    public Collection<Item> findAll(Long userId) {
        return items.values().stream()
                .filter(item -> item.getOwner().getId().equals(userId))
                .toList();
    }

    @Override
    public Collection<Item> findByText(String description) {
        return items.values().stream()
                .filter(item -> Boolean.TRUE.equals(item.getAvailable()))
                .filter(item -> item.getDescription().toLowerCase().contains(description.toLowerCase())
                        || item.getName().toLowerCase().contains(description.toLowerCase()))
                .toList();
    }

    private long getNextId() {
        long currentMaxId = items.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}

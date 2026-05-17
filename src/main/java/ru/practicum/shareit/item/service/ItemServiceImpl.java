package ru.practicum.shareit.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.exception.ValidationException;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.mapper.ItemMapper;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.item.repository.ItemRepository;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Override
    public Item save(ItemDto itemDto, Long userId) {

        User user = userRepository.findById(userId);
        Item item = ItemMapper.toItem(itemDto);

        if (item.getName() == null || item.getName().isBlank()) {
            throw new ValidationException("Название вещи не может быть пустым");
        }

        if (item.getDescription() == null || item.getDescription().isBlank()) {
            throw new ValidationException("Описание вещи не может быть пустым");
        }

        if (item.getAvailable() == null) {
            throw new ValidationException("Статус доступности должен быть указан");
        }

        item.setOwner(user);

        return itemRepository.save(item);
    }

    @Override
    public Item update(ItemDto itemDto, Long userId, Long itemId) {

        Item changedItem = itemRepository.findById(itemId);
        Item item = ItemMapper.toItem(itemDto);
        if (!changedItem.getOwner().getId().equals(userId)) {
            throw new NotFoundException("Редактировать вещь может только владелец");
        }

        return itemRepository.update(item, itemId);
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Collection<Item> findAll(Long userId) {
        return itemRepository.findAll(userId);
    }

    @Override
    public Collection<Item> findByText(String description) {
        if (description == null || description.isBlank()) {
            return List.of();
        }
        return itemRepository.findByText(description);
    }
}

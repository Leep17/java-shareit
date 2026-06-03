package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.mapper.ItemMapper;
import ru.practicum.shareit.item.service.ItemService;

import java.util.List;

/**
 * TODO Sprint add-controllers.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> findAll(@RequestHeader("X-Sharer-User-Id") Long userId) {
        return itemService.findAll(userId).stream()
                .map(ItemMapper::toItemDto)
                .toList();
    }

    @GetMapping("/{itemId}")
    public ItemDto findItemById(@PathVariable Long itemId) {

        return ItemMapper.toItemDto(itemService.findById(itemId));
    }

    @GetMapping("/search")
    public List<ItemDto> findItemsByText(@RequestParam String text) {

        return itemService.findByText(text).stream()
                .map(ItemMapper::toItemDto)
                .toList();
    }

    @PatchMapping("/{itemId}")
    public ItemDto update(@PathVariable Long itemId,
                          @RequestHeader("X-Sharer-User-Id") Long userId,
                          @RequestBody ItemDto itemDto) {
        return ItemMapper.toItemDto(itemService.update(itemDto, userId, itemId));
    }

    @PostMapping
    public ItemDto saveItem(@RequestHeader("X-Sharer-User-Id") Long userId,
                    @RequestBody ItemDto itemDto) {
        return ItemMapper.toItemDto(itemService.save(itemDto, userId));
    }

}

package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.User;
import de.nick2202.cooplist.backend.repository.ItemListRepository;
import de.nick2202.cooplist.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemListService {

    private final ItemListRepository itemListRepository;
    private final UserRepository userRepository;

    /**
     * Get all lists a user is participating in.
     *
     * @param userId Id of the user
     * @return {@link List<ItemList>} of {@link ItemList}s
     */
    public List<ItemList> getItemLists(Long userId) {
        return userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new).getItemLists();
    }

    /**
     * Get {@link ItemList}s by userId and filter them.
     *
     * @param userId     Id of the {@link User} making the request
     * @param itemListId Id of the list to get
     * @return {@link ItemList}
     */
    // functional programming example
    public ItemList getItemList(Long userId, Long itemListId) {
        return this.getItemLists(userId)
                .stream()
                .filter(itemList -> itemList.getId().equals(itemListId))
                .collect(Collectors.toList())
                .get(0);
    }

    /**
     * Make a new {@link ItemList}.
     *
     * @param name   name of the list
     * @param userId Id of the user that is making the list
     * @return {@link ItemList}
     */
    public ItemList addItemList(String name, Long userId) {
        return itemListRepository.save(
                new ItemList(name, List.of(userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new))));
    }

    /**
     * Add a new {@link User} to an existing {@link ItemList}.
     *
     * @param userId    Id of the user adding the new user
     * @param listId    Id of the list
     * @param newUserId Id of the user to be added to the list
     * @return {@link ItemList}
     */
    // functional programming example
    public ItemList addUser(Long userId, Long listId, Long newUserId) {
        return itemListRepository.save(
                itemListRepository
                        .findById(listId)
                        .stream()
                        .filter(itemList -> itemList.getUsers().contains(userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new)))
                        .findFirst()
                        .map(itemList -> ItemList.addUserToList(itemList, userRepository.findById(newUserId).orElseThrow(ResourceNotFoundException::new)))
                        .orElseThrow(ResourceNotFoundException::new));
    }

    /**
     * Delete an existing {@link ItemList}.
     *
     * @param itemList list to be deleted
     */
    public void deleteItemList(ItemList itemList) {
        itemListRepository.delete(itemList);
    }

}

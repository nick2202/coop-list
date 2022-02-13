package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.model.User;
import de.nick2202.cooplist.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    /**
     * Create new {@link User}.
     *
     * @param user user to be created
     * @return {@link User}
     */
    public User registerUser(User user) {
        return repository.save(user);
    }

    /**
     * Delete a {@link User}.
     *
     * @param id Id of the user to be deleted.
     */
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    /**
     * Get a {@link User}.
     *
     * @param id Id of the user
     * @return {@link User}
     */
    public User getUserById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No user with this Id found."));
    }
}

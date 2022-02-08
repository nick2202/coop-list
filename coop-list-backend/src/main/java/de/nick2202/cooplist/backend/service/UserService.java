package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.User;
import de.nick2202.cooplist.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {


    //    private BCryptPasswordEncoder encoder;
    private final UserRepository repo;


    public User registerBewohner(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setGroups(user.getGroups());
        System.out.println(user);
        System.out.println(newUser);
        return repo.save(newUser);
    }
}

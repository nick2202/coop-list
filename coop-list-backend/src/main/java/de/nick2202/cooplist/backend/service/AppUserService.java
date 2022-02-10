package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.AppUser;
import de.nick2202.cooplist.backend.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService {


    //    private BCryptPasswordEncoder encoder;
    private final AppUserRepository repo;


    public AppUser registerBewohner(AppUser appUser) {
        AppUser newAppUser = new AppUser();
        newAppUser.setUserName(appUser.getUserName());
        newAppUser.setPassword(appUser.getPassword());
        newAppUser.setFirstName(appUser.getFirstName());
        newAppUser.setLastName(appUser.getLastName());
        newAppUser.setItemLists(appUser.getItemLists());
        System.out.println(appUser);
        System.out.println(newAppUser);
        return repo.save(newAppUser);
    }
}

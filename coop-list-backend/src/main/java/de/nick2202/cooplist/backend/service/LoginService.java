package de.nick2202.cooplist.backend.service;
//
//import de.nick2202.cooplist.backend.exceptions.BusinessException;
//import de.nick2202.cooplist.backend.repository.BewohnerRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class LoginService {
//
//    private final BewohnerRepository repo;
//
//    public boolean validateUser(String username, String password) throws BusinessException {
//        if (username.equalsIgnoreCase(repo.findByBenutzername(username).toString())
//                && password.equals(repo.findByBenutzername(username).get().getPassword())) {
//            return true;}
//        else {
//            throw new BusinessException("User nicht vorhanden oder falsche Login-Daten");
//        }
//    }
//}

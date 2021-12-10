package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.Bewohner;
import de.nick2202.cooplist.backend.repository.BewohnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BewohnerService {


    //    private BCryptPasswordEncoder encoder;
    private final BewohnerRepository repo;


    public Bewohner registerBewohner(Bewohner bewohner) {
        Bewohner newBewohner = new Bewohner();
        newBewohner.setBenutzername(bewohner.getBenutzername());
        newBewohner.setPassword(bewohner.getPassword());
        newBewohner.setVorname(bewohner.getVorname());
        newBewohner.setNachname(bewohner.getNachname());
        newBewohner.setWg(bewohner.getWg());
        System.out.println(bewohner);
        System.out.println(newBewohner);


        return repo.save(newBewohner);
    }
}

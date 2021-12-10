package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.model.BenoetigtesProdukt;
import de.nick2202.cooplist.backend.model.Produkt;
import de.nick2202.cooplist.backend.model.Wg;
import de.nick2202.cooplist.backend.repository.BenoetigtesProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BenoetigtesProduktService {

    private final BenoetigtesProduktRepository repository;

    @Autowired
    public BenoetigtesProduktService(BenoetigtesProduktRepository repository) {
        this.repository = repository;
    }

    public BenoetigtesProdukt addBenoetigtesProdukt(Produkt produkt, Wg wg) {
        return repository.save(new BenoetigtesProdukt(produkt, wg));

    }

    public BenoetigtesProdukt buyBenoetigtesProdukt(Produkt produkt, Wg wg) {
        Optional<BenoetigtesProdukt> benoetigtesProduktOptional =
                repository.findFirstBenoetigtesProdukt(produkt, wg);
        if (benoetigtesProduktOptional.isPresent()) {
            BenoetigtesProdukt benoetigtesProdukt = benoetigtesProduktOptional.get();
            benoetigtesProdukt.setGekauft(true);
            return repository.save(benoetigtesProdukt);
        } else
            throw new ResourceNotFoundException("Produkt nicht mehr auf Shoppingliste, vermutlich bereits gekauft.\n" +
                    "Bitte aktualisiere die Seite");

    }
}

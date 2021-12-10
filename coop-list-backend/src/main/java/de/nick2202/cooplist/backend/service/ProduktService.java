package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.Produkt;
import de.nick2202.cooplist.backend.repository.ProduktRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduktService {

    private final ProduktRepository repository;

    public Optional<Produkt> getProdukt(Long id) {
        return repository.findById(id);
    }

    public List<Produkt> getProdukteByName(String name) {
        return repository.findAllByName(name);
    }

    public Produkt addProdukt(Produkt produkt) {
        return repository.save(produkt);
    }

}

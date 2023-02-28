package pl.arkadiusz.SpringAndSwagger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arkadiusz.SpringAndSwagger.model.Address;
import pl.arkadiusz.SpringAndSwagger.model.Facture;
import pl.arkadiusz.SpringAndSwagger.model.User;
import pl.arkadiusz.SpringAndSwagger.repository.FactureRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureService {

    @Autowired
    private final FactureRepository factureRepository;

    public List<Facture> getFactures(){
        return factureRepository.findAll();
    }

    public List<Facture> findAbove(double total) {
        return factureRepository.findByTotalGreaterThan(total);
    }

    public Facture addFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    public void editFacture(Facture facture) {
        factureRepository.save(facture);
    }

    public void deleteFacture(long id) {
        factureRepository.deleteById(id);
    }
}

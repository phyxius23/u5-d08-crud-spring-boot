package it.crudspring.gestioneprenotazioni.edifici;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificiService {

  @Autowired
  EdificiRepository edificiRepo;

  // salva un edificio
  public Edificio create(Edificio e) {
    return edificiRepo.save(e);
  }

  // restituisce una lista di edifici
  public List<Edificio> find() {
    return edificiRepo.findAll();
  }

  // restituisce un edificio
  public Edificio findById(UUID edificioId) throws Exception {
    return edificiRepo.findById(edificioId).orElseThrow(() -> new Exception("Edificio non trovato!"));
  }

  // torna un edificio aggiornato
  public Edificio findByIdAndUpdate(UUID edificioId, Edificio e) throws Exception {
    Edificio found = this.findById(edificioId);

    found.setId(edificioId);
    found.setName(e.getName());
    found.setAddress(e.getAddress());
    found.setCity(e.getCity());

    return edificiRepo.save(found);
  }

  // elimina un edificio specifico
  public void findByIdAndDelete(UUID edificioId) throws Exception {
    Edificio found = this.findById(edificioId);
    edificiRepo.delete(found);
  }

}

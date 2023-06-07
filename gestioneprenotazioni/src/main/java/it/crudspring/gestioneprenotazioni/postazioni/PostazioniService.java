package it.crudspring.gestioneprenotazioni.postazioni;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.crudspring.gestioneprenotazioni.edifici.Edificio;

@Service
public class PostazioniService {

  @Autowired
  PostazioniRepository postazioniRepo;

  // salva un utente
  public Postazione create(Postazione u) {
    return postazioniRepo.save(u);
  }

  // restituisce una lista di utenti
  public List<Postazione> find() {
    return postazioniRepo.findAll();
  }

  // restituisce un utente
  public Postazione findById(UUID id) throws Exception {
    return postazioniRepo.findById(id).orElseThrow(() -> new Exception("Postazione non trovata!"));
  }

  // torna un utente aggiornato
  public Postazione findByIdAndUpdate(UUID id, Postazione p) throws Exception {
    Postazione found = this.findById(id);

    found.setDescription(p.getDescription());
    found.setEdificio(p.getEdificio());
    found.setMaxPax(p.getMaxPax());
    found.setType(p.getType());

    return postazioniRepo.save(found);
  }

  // elimina un utente in base all'id
  public void findByIdAndDelete(UUID id) throws Exception {
    Postazione found = this.findById(id);

    // postazioniRepo.deleteById(id); // questa può sostituire quella sotto
    postazioniRepo.delete(found);
  }

  // cerca una postazione per tipo e città
  public List<Postazione> findByTypeAndCity() {

  }
}

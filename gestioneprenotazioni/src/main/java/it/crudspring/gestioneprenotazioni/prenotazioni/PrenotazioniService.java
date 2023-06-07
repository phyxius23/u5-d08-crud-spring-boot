package it.crudspring.gestioneprenotazioni.prenotazioni;

// import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import it.crudspring.gestioneprenotazioni.postazioni.Postazione;

@Service
public class PrenotazioniService {

  @Autowired
  PrenotazioniRepository prenotazioniRepo;

  // salva una prenotazione
  public Prenotazione createPrenotazione(Prenotazione p) {
    return prenotazioniRepo.save(p);
  }

  // restituisce una lista di prenotazioni
  public List<Prenotazione> find() {
    return prenotazioniRepo.findAll();
  }

  // restituisce una prenotazione
  public Prenotazione findById(UUID prenotazioneId) throws Exception {
    return prenotazioniRepo.findById(prenotazioneId).orElseThrow(() -> new Exception("Prenotazione non trovata!"));
  }

  // torna una prenotazione aggiornata
  public Prenotazione findByIdAndUpdate(UUID prenotazioneId, Prenotazione p) throws Exception {
    Prenotazione found = this.findById(prenotazioneId);

    found.setId(prenotazioneId);
    found.setReservationDay(p.getReservationDay());
    found.setUser(p.getUser());
    found.setPostazione(p.getPostazione());

    return prenotazioniRepo.save(found);
  }

  // elimina una prenotazione in base all'id
  public void findByIdAndDelete(UUID prenotazioneId) throws Exception {
    Prenotazione found = this.findById(prenotazioneId);

    prenotazioniRepo.delete(found);
  }

  //
  // public void findByDataAndPostazione(LocalDate date, Postazione postazione) {
  // prenotazioniRepo.findByDataAndPostazione(date, postazione).ifPresent(value ->
  // new Exception("Postazione occupata"));
  // }

}

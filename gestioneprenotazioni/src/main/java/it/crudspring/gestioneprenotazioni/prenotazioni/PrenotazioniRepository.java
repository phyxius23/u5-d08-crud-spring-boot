package it.crudspring.gestioneprenotazioni.prenotazioni;

// import java.time.LocalDate;
// import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// import it.crudspring.gestioneprenotazioni.postazioni.Postazione;

public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

  // Optional<Prenotazione> findByDataAndPostazione(LocalDate data, Postazione
  // postazione);

}

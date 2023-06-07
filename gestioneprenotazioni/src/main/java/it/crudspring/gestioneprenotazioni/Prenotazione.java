package it.crudspring.gestioneprenotazioni;

import java.time.LocalDate;
import java.util.UUID;

import it.crudspring.gestioneprenotazioni.postazioni.Postazione;
import it.crudspring.gestioneprenotazioni.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
public class Prenotazione {

  // Attributi
  private UUID id;
  private LocalDate reservationDay;

  // devo creare i collegamenti con le altre tabelle
  private User user;
  private Postazione postazione;

  // Costruttore
  public Prenotazione(LocalDate reservationDay, User user, Postazione postazione) {
    this.reservationDay = reservationDay;
    this.user = user;
    this.postazione = postazione;
  }

}

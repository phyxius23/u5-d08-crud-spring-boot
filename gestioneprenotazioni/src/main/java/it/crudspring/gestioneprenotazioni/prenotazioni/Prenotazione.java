package it.crudspring.gestioneprenotazioni.prenotazioni;

import java.time.LocalDate;
import java.util.UUID;

import it.crudspring.gestioneprenotazioni.postazioni.Postazione;
import it.crudspring.gestioneprenotazioni.users.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
public class Prenotazione {

  // Attributi
  @Id
  @GeneratedValue
  private UUID id;
  private LocalDate reservationDay;

  // devo creare i collegamenti con le altre tabelle
  @ManyToOne(cascade = CascadeType.ALL)
  private User user;
  @ManyToOne(cascade = CascadeType.ALL)
  private Postazione postazione;

  // Costruttore
  public Prenotazione(LocalDate reservationDay, User user, Postazione postazione) {
    this.reservationDay = reservationDay;
    this.user = user;
    this.postazione = postazione;
  }

}

package it.crudspring.gestioneprenotazioni.postazioni;

import java.util.UUID;

import it.crudspring.gestioneprenotazioni.edifici.Edificio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@Data
@NoArgsConstructor
public class Postazione {

  // Attributi
  @Id
  @GeneratedValue
  private UUID id;
  private String description;
  private PostazioneType type;
  private int maxPax;

  // qui devo eseguire il collegamento
  private Edificio edificio;

  // Costruttore
  public Postazione(String description, PostazioneType type, int maxPax, Edificio edificio) {
    this.description = description;
    this.type = type;
    this.maxPax = maxPax;
    this.edificio = edificio;
  }

}

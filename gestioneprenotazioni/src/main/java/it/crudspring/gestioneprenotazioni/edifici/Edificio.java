package it.crudspring.gestioneprenotazioni.edifici;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "edifici")
@Data
@NoArgsConstructor
public class Edificio {

  // Attributi
  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private String address;
  private String city;

  // Costruttore
  public Edificio(String name, String address, String city) {
    this.name = name;
    this.address = address;
    this.city = city;
  }

}

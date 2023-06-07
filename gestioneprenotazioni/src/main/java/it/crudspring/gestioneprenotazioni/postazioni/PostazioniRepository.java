package it.crudspring.gestioneprenotazioni.postazioni;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostazioniRepository extends JpaRepository<Postazione, UUID> {

}

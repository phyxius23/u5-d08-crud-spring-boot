package it.crudspring.gestioneprenotazioni.edifici;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, UUID> {

}

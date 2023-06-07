package it.crudspring.gestioneprenotazioni.postazioni;

// import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostazioniRepository extends JpaRepository<Postazione, UUID> {

  // metodo non funzionante -> WHY???
  // public List<Postazione> findByTypeAndCityRepo(String city, PostazioneType
  // postazioneType);

}

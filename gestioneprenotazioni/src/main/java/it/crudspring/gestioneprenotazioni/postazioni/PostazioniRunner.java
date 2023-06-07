package it.crudspring.gestioneprenotazioni.postazioni;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.crudspring.gestioneprenotazioni.edifici.EdificiService;
import it.crudspring.gestioneprenotazioni.edifici.Edificio;

import com.github.javafaker.Faker;

@Component
public class PostazioniRunner implements CommandLineRunner {

  @Autowired
  PostazioniService postazioneService;

  @Autowired
  EdificiService edificiService;

  @Override
  public void run(String... args) throws Exception {

    List<Edificio> edificiSalvati = edificiService.find();

    Faker faker = new Faker(new Locale("it"));

    for (int i = 0; i < 0; i++) {
      String description = faker.lorem().paragraph(2);

      int randomPostazioneType = new Random().nextInt(PostazioneType.values().length);
      PostazioneType type = PostazioneType.values()[randomPostazioneType];

      int maxPax = faker.number().numberBetween(1, 10);

      int indexRandom = new Random().nextInt(edificiSalvati.size());
      Edificio randomEdifici = edificiSalvati.get(indexRandom);

      Postazione postazione = new Postazione(description, type, maxPax, randomEdifici);

      postazioneService.create(postazione);
    }
  }

}

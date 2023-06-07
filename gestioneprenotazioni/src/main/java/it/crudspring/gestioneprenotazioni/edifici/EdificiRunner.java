package it.crudspring.gestioneprenotazioni.edifici;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class EdificiRunner implements CommandLineRunner {

  @Autowired
  EdificiService edificiService;

  @Override
  public void run(String... args) throws Exception {

    Faker faker = new Faker(new Locale("it"));

    for (int i = 0; i < 0; i++) {
      String name = faker.university().name();
      String address = faker.address().streetAddress();
      String city = faker.address().city();

      Edificio edificio = new Edificio(name, address, city);

      edificiService.create(edificio);
    }
  }

}

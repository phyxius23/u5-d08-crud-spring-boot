package it.crudspring.gestioneprenotazioni.users;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class UsersRunner implements CommandLineRunner {

  @Autowired
  UsersService usersService;

  @Override
  public void run(String... args) throws Exception {

    Faker faker = new Faker(new Locale("it"));

    for (int i = 0; i < 0; i++) {

      String username = faker.name().username();
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = faker.internet().emailAddress();

      User user = new User(username, firstName, lastName, email);

      usersService.create(user);
    }
  }

}

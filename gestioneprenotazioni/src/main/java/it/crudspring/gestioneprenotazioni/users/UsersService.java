package it.crudspring.gestioneprenotazioni.users;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  UsersRepository usersRepo;

  // salva un utente
  public User create(User u) {
    // TODO: check if email already exists

    return usersRepo.save(u);
  }

  // restituisce una lista di utenti
  public List<User> find() {
    return usersRepo.findAll();
  }

  // restituisce un utente
  public User findById(UUID id) throws Exception {
    return usersRepo.findById(id).orElseThrow(() -> new Exception("Utente non trovato!"));
  }

  // torna un utente aggiornato
  public User findByIdAndUpdate(UUID id, User u) throws Exception {
    User found = this.findById(id);

    found.setId(id);
    found.setFirstName(u.getFirstName());
    found.setLastName(u.getLastName());
    found.setEmail(u.getEmail());

    return usersRepo.save(found);
  }

  // elimina un utente in base all'id
  public void findByIdAndDelete(UUID id) throws Exception {
    User found = this.findById(id);

    // usersRepo.deleteById(id); // questa può sostituire quella sotto
    usersRepo.delete(found);
  }
}

package it.crudspring.gestioneprenotazioni.prenotazioni;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

  @Autowired
  PrenotazioniService prenotazioniService;

  @GetMapping("")
  public List<Prenotazione> getPrenotazioni() {
    return prenotazioniService.find();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Prenotazione savePrenotazione(@RequestBody Prenotazione body) {
    return prenotazioniService.createPrenotazione(body);
  }

  @GetMapping("/{prenotazioneId}")
  public Prenotazione getPrenotazione(@PathVariable UUID prenotazioneId) throws Exception {
    return prenotazioniService.findById(prenotazioneId);
  }

  @PutMapping("/{prenotazioneId}")
  public Prenotazione putPrenotazione(@PathVariable UUID prenotazioneId, @RequestBody Prenotazione body)
      throws Exception {
    return prenotazioniService.findByIdAndUpdate(prenotazioneId, body);
  }

  @DeleteMapping("/{prenotazioneId}")
  public void deletePrenotazione(@PathVariable UUID prenotazioneId) throws Exception {
    prenotazioniService.findByIdAndDelete(prenotazioneId);
  }
}

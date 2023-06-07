package it.crudspring.gestioneprenotazioni.edifici;

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
@RequestMapping("/edifici")
public class EdificiController {

  @Autowired
  EdificiService edificiService;

  @GetMapping("")
  public List<Edificio> getEdifici() {
    return edificiService.find();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Edificio saveEdificio(@RequestBody Edificio body) {
    return edificiService.create(body);
  }

  @GetMapping("/{edificioId}")
  public Edificio getEdificio(@PathVariable UUID edificioId) throws Exception {
    return edificiService.findById(edificioId);
  }

  @PutMapping("/{edificioId}")
  public Edificio putEdificio(@PathVariable UUID edificioId, @RequestBody Edificio body) throws Exception {
    return edificiService.findByIdAndUpdate(edificioId, body);
  }

  @DeleteMapping("/{edificioId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEdificio(UUID edificioId) throws Exception {
    edificiService.findByIdAndDelete(edificioId);
  }
}

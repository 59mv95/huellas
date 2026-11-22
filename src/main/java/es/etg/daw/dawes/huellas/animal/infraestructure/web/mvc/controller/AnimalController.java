package es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.HtmlUtils;

import es.etg.daw.dawes.huellas.animal.application.command.CreateAnimalCommand;
import es.etg.daw.dawes.huellas.animal.application.command.EditAnimalCommand;
import es.etg.daw.dawes.huellas.animal.application.service.CreateAnimalService;
import es.etg.daw.dawes.huellas.animal.application.service.DeleteAnimalService;
import es.etg.daw.dawes.huellas.animal.application.service.EditAnimalService;
import es.etg.daw.dawes.huellas.animal.application.service.FindAnimalService;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.infraestructure.mapper.AnimalMapper;
import es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto.AnimalRequest;
import es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto.AnimalResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/animales")
@RequiredArgsConstructor
public class AnimalController {

    private final CreateAnimalService createAnimalService;
    private final FindAnimalService findAnimalService;
    private final EditAnimalService editAnimalService;
    private final DeleteAnimalService deleteAnimalService;

    private final AnimalMapper animalMapper;

    @PostMapping
    @ResponseBody
    public String createAnimal(@Valid AnimalRequest request) {

        CreateAnimalCommand comando = animalMapper.toCommand(request);
        Animal animal = createAnimalService.createAnimal(comando);

        return """
            <!DOCTYPE html>
            <html lang="es">
              <head><meta charset="UTF-8"><title>Animal creado</title></head>
              <body>
                <h1>%s - %s</h1>
                <p>Tipo: %s · Raza: %s</p>
                <p>Edad: %s años · Sexo: %s</p>
                <p>Estado: %s</p>
                <p>Dado de alta el: %s</p>
                <a href="/animales.html">Volver</a>
              </body>
            </html>
            """.formatted(
                animal.getId(),
                HtmlUtils.htmlEscape(animal.getNombre()),
                animal.getEspecie(),
                HtmlUtils.htmlEscape(String.valueOf(animal.getRaza())),
                animal.getEdad(),
                animal.getSexo(),
                animal.getEstado(),
                animal.getCreatedAt());
    }

    @GetMapping
    @ResponseBody
    public List<AnimalResponse> allAnimales(@RequestParam(required = false) Especie especie) {

        List<Animal> animales = (especie == null)
                ? findAnimalService.findAll()
                : findAnimalService.findByEspecie(especie);

        return animales.stream()
                .map(animalMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AnimalResponse getAnimal(@PathVariable int id) {
        return animalMapper.toResponse(findAnimalService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public AnimalResponse editAnimal(@PathVariable int id, @RequestBody AnimalRequest request) {

        EditAnimalCommand comando = animalMapper.toCommand(id, request);
        Animal animal = editAnimalService.update(comando);

        return animalMapper.toResponse(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        deleteAnimalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {

        StringBuilder html = new StringBuilder(256);
        html.append("<!DOCTYPE html><html lang=\"es\"><head><meta charset=\"UTF-8\">")
            .append("<title>Errores de validación</title></head><body>")
            .append("<h1>Errores de validación</h1><ul>");

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String campo = (error instanceof FieldError fe) ? fe.getField() : error.getObjectName();
            html.append("<li><strong>").append(HtmlUtils.htmlEscape(campo)).append("</strong>: ")
                .append(HtmlUtils.htmlEscape(error.getDefaultMessage())).append("</li>");
        });

        html.append("</ul></body></html>");
        return html.toString();
    }
}
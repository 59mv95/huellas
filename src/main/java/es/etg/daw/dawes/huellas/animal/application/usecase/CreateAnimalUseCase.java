package es.etg.daw.dawes.huellas.animal.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.huellas.animal.application.command.CreateAnimalCommand;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.EstadoAdopcion;
import es.etg.daw.dawes.huellas.animal.domain.repository.AnimalRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAnimalUseCase {

    private AnimalRepository animalRepository;

    public Animal create(CreateAnimalCommand comando) {

        EstadoAdopcion estado = (comando.estado() == null) ? EstadoAdopcion.DISPONIBLE : comando.estado();

        Animal animal = Animal.builder()
                .nombre(comando.nombre().trim())
                .especie(comando.especie())
                .raza(comando.raza())
                .edad(comando.edad())
                .sexo(comando.sexo())
                .tamano(comando.tamano())
                .peso(comando.peso())
                .personalidad(comando.personalidad())
                .descripcion(comando.descripcion())
                .foto(comando.foto())
                .estado(estado)
                .vacunado(comando.vacunado())
                .esterilizado(comando.esterilizado())
                .createdAt(LocalDateTime.now())
                .build();

        return animalRepository.save(animal);
    }
}
package es.etg.daw.dawes.huellas.animal.application.usecase;

import es.etg.daw.dawes.huellas.animal.application.command.EditAnimalCommand;
import es.etg.daw.dawes.huellas.animal.domain.error.AnimalNotFoundException;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.repository.AnimalRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditAnimalUseCase {

    private AnimalRepository animalRepository;

    public Animal update(EditAnimalCommand comando) {

        Animal animal = animalRepository.getById(comando.id())
                .orElseThrow(() -> new AnimalNotFoundException(comando.id()));

        animal.setFoto(comando.foto());
        animal.setEdad(comando.edad());
        animal.setPeso(comando.peso());
        animal.setPersonalidad(comando.personalidad());
        animal.setDescripcion(comando.descripcion());
        if (comando.estado() != null)
            animal.setEstado(comando.estado());
        animal.setVacunado(comando.vacunado());
        animal.setEsterilizado(comando.esterilizado());

        return animalRepository.save(animal);
    }
}
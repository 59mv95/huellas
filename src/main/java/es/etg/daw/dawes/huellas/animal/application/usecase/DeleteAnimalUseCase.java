package es.etg.daw.dawes.huellas.animal.application.usecase;

import es.etg.daw.dawes.huellas.animal.domain.error.AnimalNotFoundException;
import es.etg.daw.dawes.huellas.animal.domain.repository.AnimalRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAnimalUseCase {

    private AnimalRepository animalRepository;

    public void delete(int id) {
        animalRepository.getById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
        animalRepository.deleteById(id);
    }
}
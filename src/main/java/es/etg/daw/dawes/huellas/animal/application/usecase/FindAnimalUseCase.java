package es.etg.daw.dawes.huellas.animal.application.usecase;

import java.util.List;

import es.etg.daw.dawes.huellas.animal.domain.error.AnimalNotFoundException;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.domain.repository.AnimalRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindAnimalUseCase {

    private AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.getAll();
    }

    public List<Animal> findByEspecie(Especie especie) {
        return animalRepository.getByEspecie(especie);
    }

    public Animal findById(int id) {
        return animalRepository.getById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }
}
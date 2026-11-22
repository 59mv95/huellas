package es.etg.daw.dawes.huellas.animal.application.service;

import java.util.List;

import es.etg.daw.dawes.huellas.animal.application.usecase.FindAnimalUseCase;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAnimalService {

    private final FindAnimalUseCase findAnimalUseCase;

    public List<Animal> findAll() {
        return findAnimalUseCase.findAll();
    }

    public List<Animal> findByEspecie(Especie especie) {
        return findAnimalUseCase.findByEspecie(especie);
    }

    public Animal findById(int id) {
        return findAnimalUseCase.findById(id);
    }
}
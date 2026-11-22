package es.etg.daw.dawes.huellas.animal.application.service;

import es.etg.daw.dawes.huellas.animal.application.command.CreateAnimalCommand;
import es.etg.daw.dawes.huellas.animal.application.usecase.CreateAnimalUseCase;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAnimalService {

    private final CreateAnimalUseCase createAnimalUseCase;

    public Animal createAnimal(CreateAnimalCommand comando) {
        return createAnimalUseCase.create(comando);
    }
}
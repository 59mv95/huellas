package es.etg.daw.dawes.huellas.animal.application.service;

import es.etg.daw.dawes.huellas.animal.application.command.EditAnimalCommand;
import es.etg.daw.dawes.huellas.animal.application.usecase.EditAnimalUseCase;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditAnimalService {

    private final EditAnimalUseCase editAnimalUseCase;

    public Animal update(EditAnimalCommand comando) {
        return editAnimalUseCase.update(comando);
    }
}
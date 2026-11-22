package es.etg.daw.dawes.huellas.animal.application.service;

import es.etg.daw.dawes.huellas.animal.application.usecase.DeleteAnimalUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAnimalService {

    private final DeleteAnimalUseCase deleteAnimalUseCase;

    public void delete(int id) {
        deleteAnimalUseCase.delete(id);
    }
}
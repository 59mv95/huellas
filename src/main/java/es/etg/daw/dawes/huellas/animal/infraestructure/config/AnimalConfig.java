package es.etg.daw.dawes.huellas.animal.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.huellas.animal.application.service.CreateAnimalService;
import es.etg.daw.dawes.huellas.animal.application.service.DeleteAnimalService;
import es.etg.daw.dawes.huellas.animal.application.service.EditAnimalService;
import es.etg.daw.dawes.huellas.animal.application.service.FindAnimalService;
import es.etg.daw.dawes.huellas.animal.application.usecase.CreateAnimalUseCase;
import es.etg.daw.dawes.huellas.animal.application.usecase.DeleteAnimalUseCase;
import es.etg.daw.dawes.huellas.animal.application.usecase.EditAnimalUseCase;
import es.etg.daw.dawes.huellas.animal.application.usecase.FindAnimalUseCase;
import es.etg.daw.dawes.huellas.animal.domain.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AnimalConfig {

    private final AnimalRepository animalRepository;

    @Bean
    public CreateAnimalUseCase createAnimalUseCase() {
        return new CreateAnimalUseCase(animalRepository);
    }

    @Bean
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalService(createAnimalUseCase());
    }

    @Bean
    public FindAnimalUseCase findAnimalUseCase() {
        return new FindAnimalUseCase(animalRepository);
    }

    @Bean
    public FindAnimalService findAnimalService() {
        return new FindAnimalService(findAnimalUseCase());
    }

    @Bean
    public EditAnimalUseCase editAnimalUseCase() {
        return new EditAnimalUseCase(animalRepository);
    }

    @Bean
    public EditAnimalService editAnimalService() {
        return new EditAnimalService(editAnimalUseCase());
    }

    @Bean
    public DeleteAnimalUseCase deleteAnimalUseCase() {
        return new DeleteAnimalUseCase(animalRepository);
    }

    @Bean
    public DeleteAnimalService deleteAnimalService() {
        return new DeleteAnimalService(deleteAnimalUseCase());
    }
}
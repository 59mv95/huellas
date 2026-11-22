package es.etg.daw.dawes.huellas.animal.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dawes.huellas.animal.application.command.CreateAnimalCommand;
import es.etg.daw.dawes.huellas.animal.application.command.EditAnimalCommand;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto.AnimalRequest;
import es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto.AnimalResponse;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    CreateAnimalCommand toCommand(AnimalRequest request);

    AnimalResponse toResponse(Animal animal);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "request.foto", target = "foto")
    @Mapping(source = "request.edad", target = "edad")
    @Mapping(source = "request.peso", target = "peso")
    @Mapping(source = "request.personalidad", target = "personalidad")
    @Mapping(source = "request.descripcion", target = "descripcion")
    @Mapping(source = "request.estado", target = "estado")
    @Mapping(source = "request.vacunado", target = "vacunado")
    @Mapping(source = "request.esterilizado", target = "esterilizado")
    EditAnimalCommand toCommand(int id, AnimalRequest request);
}
package es.etg.daw.dawes.huellas.animal.infraestructure.mapper;

import es.etg.daw.dawes.huellas.animal.application.command.CreateAnimalCommand;
import es.etg.daw.dawes.huellas.animal.application.command.EditAnimalCommand;
import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.domain.model.EstadoAdopcion;
import es.etg.daw.dawes.huellas.animal.domain.model.Sexo;
import es.etg.daw.dawes.huellas.animal.domain.model.Tamano;
import es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto.AnimalRequest;
import es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto.AnimalResponse;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-22T14:02:56+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Debian)"
)
@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public CreateAnimalCommand toCommand(AnimalRequest request) {
        if ( request == null ) {
            return null;
        }

        String nombre = null;
        Especie especie = null;
        String raza = null;
        int edad = 0;
        Sexo sexo = null;
        Tamano tamano = null;
        double peso = 0.0d;
        String personalidad = null;
        String descripcion = null;
        String foto = null;
        EstadoAdopcion estado = null;
        boolean vacunado = false;
        boolean esterilizado = false;

        nombre = request.nombre();
        especie = request.especie();
        raza = request.raza();
        edad = request.edad();
        sexo = request.sexo();
        tamano = request.tamano();
        peso = request.peso();
        personalidad = request.personalidad();
        descripcion = request.descripcion();
        foto = request.foto();
        estado = request.estado();
        vacunado = request.vacunado();
        esterilizado = request.esterilizado();

        CreateAnimalCommand createAnimalCommand = new CreateAnimalCommand( nombre, especie, raza, edad, sexo, tamano, peso, personalidad, descripcion, foto, estado, vacunado, esterilizado );

        return createAnimalCommand;
    }

    @Override
    public AnimalResponse toResponse(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        int id = 0;
        String nombre = null;
        Especie especie = null;
        String raza = null;
        int edad = 0;
        Sexo sexo = null;
        Tamano tamano = null;
        double peso = 0.0d;
        String personalidad = null;
        String descripcion = null;
        String foto = null;
        EstadoAdopcion estado = null;
        boolean vacunado = false;
        boolean esterilizado = false;
        LocalDateTime createdAt = null;

        id = animal.getId();
        nombre = animal.getNombre();
        especie = animal.getEspecie();
        raza = animal.getRaza();
        edad = animal.getEdad();
        sexo = animal.getSexo();
        tamano = animal.getTamano();
        peso = animal.getPeso();
        personalidad = animal.getPersonalidad();
        descripcion = animal.getDescripcion();
        foto = animal.getFoto();
        estado = animal.getEstado();
        vacunado = animal.isVacunado();
        esterilizado = animal.isEsterilizado();
        createdAt = animal.getCreatedAt();

        AnimalResponse animalResponse = new AnimalResponse( id, nombre, especie, raza, edad, sexo, tamano, peso, personalidad, descripcion, foto, estado, vacunado, esterilizado, createdAt );

        return animalResponse;
    }

    @Override
    public EditAnimalCommand toCommand(int id, AnimalRequest request) {
        if ( request == null ) {
            return null;
        }

        String foto = null;
        int edad = 0;
        double peso = 0.0d;
        String personalidad = null;
        String descripcion = null;
        EstadoAdopcion estado = null;
        boolean vacunado = false;
        boolean esterilizado = false;
        if ( request != null ) {
            foto = request.foto();
            edad = request.edad();
            peso = request.peso();
            personalidad = request.personalidad();
            descripcion = request.descripcion();
            estado = request.estado();
            vacunado = request.vacunado();
            esterilizado = request.esterilizado();
        }
        int id1 = 0;
        id1 = id;

        EditAnimalCommand editAnimalCommand = new EditAnimalCommand( id1, foto, edad, peso, personalidad, descripcion, estado, vacunado, esterilizado );

        return editAnimalCommand;
    }
}

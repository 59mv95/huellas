package es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

import es.etg.daw.dawes.huellas.animal.domain.model.EstadoAdopcion;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.domain.model.Sexo;
import es.etg.daw.dawes.huellas.animal.domain.model.Tamano;

public record AnimalResponse(int id, String nombre, Especie especie, String raza, int edad,
        Sexo sexo, Tamano tamano, double peso, String personalidad, String descripcion,
        String foto, EstadoAdopcion estado, boolean vacunado, boolean esterilizado,
        LocalDateTime createdAt) {
}
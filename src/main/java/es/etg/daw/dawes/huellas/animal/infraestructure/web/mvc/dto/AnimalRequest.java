package es.etg.daw.dawes.huellas.animal.infraestructure.web.mvc.dto;

import es.etg.daw.dawes.huellas.animal.domain.model.EstadoAdopcion;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.domain.model.Sexo;
import es.etg.daw.dawes.huellas.animal.domain.model.Tamano;
import es.etg.daw.dawes.huellas.animal.infraestructure.web.validation.NombreAnimal;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record AnimalRequest(
    @NotBlank(message = "{animal.valid.nombre.no_vacio}")
    @NombreAnimal(message = "{animal.valid.nombre.formato}")
    String nombre,

    @NotNull(message = "{animal.valid.especie.no_vacio}")
    Especie especie,

    String raza,

    @Min(value = 0, message = "{animal.valid.edad.min}")
    @Max(value = 30, message = "{animal.valid.edad.max}")
    int edad,

    @NotNull(message = "{animal.valid.sexo.no_vacio}")
    Sexo sexo,

    Tamano tamano,

    @PositiveOrZero(message = "{animal.valid.peso.min}")
    double peso,

    @Size(max = 100, message = "{animal.valid.personalidad.max}")
    String personalidad,

    @Size(max = 500, message = "{animal.valid.descripcion.max}")
    String descripcion,

    String foto,
    EstadoAdopcion estado,
    boolean vacunado,
    boolean esterilizado) {
}
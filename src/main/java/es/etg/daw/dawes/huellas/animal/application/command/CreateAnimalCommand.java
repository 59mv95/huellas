package es.etg.daw.dawes.huellas.animal.application.command;

import es.etg.daw.dawes.huellas.animal.domain.model.EstadoAdopcion;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.domain.model.Sexo;
import es.etg.daw.dawes.huellas.animal.domain.model.Tamano;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true) 
public class CreateAnimalCommand {

    private String nombre;
    private Especie especie;
    private String raza;
    private int edad;
    private Sexo sexo;
    private Tamano tamano;
    private double peso;
    private String personalidad;
    private String descripcion;
    private String foto;
    private EstadoAdopcion estado;
    private boolean vacunado;
    private boolean esterilizado;
}
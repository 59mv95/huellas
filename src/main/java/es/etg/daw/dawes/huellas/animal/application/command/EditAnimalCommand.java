package es.etg.daw.dawes.huellas.animal.application.command;

import es.etg.daw.dawes.huellas.animal.domain.model.EstadoAdopcion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditAnimalCommand {

    private int id;
    private String foto;
    private int edad;
    private double peso;
    private String personalidad;
    private String descripcion;
    private EstadoAdopcion estado;
    private boolean vacunado;
    private boolean esterilizado;
}
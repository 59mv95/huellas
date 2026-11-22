package es.etg.daw.dawes.huellas.animal.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Animal {

    private int id;
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
    private LocalDateTime createdAt;
}
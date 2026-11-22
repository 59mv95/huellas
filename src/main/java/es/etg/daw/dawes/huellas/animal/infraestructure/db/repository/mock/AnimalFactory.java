package es.etg.daw.dawes.huellas.animal.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.EstadoAdopcion;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.domain.model.Sexo;
import es.etg.daw.dawes.huellas.animal.domain.model.Tamano;

public class AnimalFactory {

    public static final Map<Integer, Animal> getDemoData() {
        Map<Integer, Animal> datos = new LinkedHashMap<>();

        datos.put(1, Animal.builder().id(1).nombre("Max").especie(Especie.PERRO).raza("Jack Russell")
                .edad(2).sexo(Sexo.MACHO).tamano(Tamano.PEQUENO).peso(7.5)
                .personalidad("Muy juguetón y cariñoso")
                .descripcion("Adora que le den mimos y tiene muchísima energía.")
                .foto("/img/max.jpg").estado(EstadoAdopcion.DISPONIBLE)
                .vacunado(true).esterilizado(true).createdAt(LocalDateTime.now()).build());

        datos.put(2, Animal.builder().id(2).nombre("Pipo y Pepa").especie(Especie.AVE).raza("Agapornis")
                .edad(1).sexo(Sexo.MACHO).tamano(Tamano.PEQUENO).peso(0.05)
                .personalidad("Inseparables y muy alegres")
                .descripcion("Se adoptan siempre juntos.")
                .foto("/img/pipo-pepa.jpg").estado(EstadoAdopcion.EN_PROCESO)
                .vacunado(false).esterilizado(false).createdAt(LocalDateTime.now()).build());

        datos.put(3, Animal.builder().id(3).nombre("Ámbar").especie(Especie.GATO).raza("Común europeo")
                .edad(3).sexo(Sexo.HEMBRA).tamano(Tamano.MEDIANO).peso(4)
                .personalidad("Reservada pero coge afecto en poco tiempo")
                .descripcion("Le encanta que le rasquen la barriga.")
                .foto("/img/ambar.jpg").estado(EstadoAdopcion.NO_DISPONIBLE)
                .vacunado(true).esterilizado(true).createdAt(LocalDateTime.now()).build());

        return datos;
    }
}
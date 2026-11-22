package es.etg.daw.dawes.huellas.animal.domain.repository;

import java.util.List;

import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;

public interface AnimalRepository extends CRUDRepository<Animal, Integer> {

    public List<Animal> getByEspecie(Especie especie);
}
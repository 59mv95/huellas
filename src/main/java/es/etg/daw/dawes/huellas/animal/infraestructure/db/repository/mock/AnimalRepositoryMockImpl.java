package es.etg.daw.dawes.huellas.animal.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.huellas.animal.domain.model.Animal;
import es.etg.daw.dawes.huellas.animal.domain.model.Especie;
import es.etg.daw.dawes.huellas.animal.domain.repository.AnimalRepository;

@Repository
public class AnimalRepositoryMockImpl implements AnimalRepository {

    private final Map<Integer, Animal> animales = AnimalFactory.getDemoData();

    @Override
    public Animal save(Animal a) {
        if (a.getId() == 0)
            a.setId(obtenerSiguienteId());
        animales.put(a.getId(), a);
        return a;
    }

    private int obtenerSiguienteId() {
        int mayor = 0;
        for (Integer id : animales.keySet()) {
            if (id > mayor)
                mayor = id;
        }
        return mayor + 1;
    }

    @Override
    public List<Animal> getAll() {
        return new ArrayList<>(animales.values());
    }

    @Override
    public Optional<Animal> getById(Integer id) {
        return Optional.ofNullable(animales.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        animales.remove(id);
    }

    @Override
    public List<Animal> getByEspecie(Especie especie) {
        return animales.values().stream()
                .filter(a -> a.getEspecie() == especie)
                .toList();
    }
}
package es.etg.daw.dawes.huellas.animal.domain.error;

public class AnimalNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "animal";

    public AnimalNotFoundException() {
        super(ENTIDAD);
    }

    public AnimalNotFoundException(int id) {
        super(ENTIDAD, id);
    }
}
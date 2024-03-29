package com.universidad.informacionacademica.domain.estudiante.values;

import co.com.sofka.domain.generic.Identity;
import com.universidad.informacionacademica.domain.asignatura.values.IdFacultad;

public class IdEstudiante extends Identity {
    public IdEstudiante(String value) {
        super(value);
    }

    public IdEstudiante() {
    }

    public static IdEstudiante of(String value) {
        return new IdEstudiante(value);
    }
}

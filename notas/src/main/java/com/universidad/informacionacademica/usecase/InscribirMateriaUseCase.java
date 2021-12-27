package com.universidad.informacionacademica.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.universidad.informacionacademica.domain.estudiante.Estudiante;
import com.universidad.informacionacademica.domain.estudiante.commands.InscribirMateriaCommand;

public class InscribirMateriaUseCase extends UseCase<RequestCommand<InscribirMateriaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<InscribirMateriaCommand> requestCommand){
        var command = requestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudiante().identity(),retrieveEvents());
        if(estudiante.asignaturasInscritas().contains(command.getAsignatura())){
            throw new BusinessException(command.getEstudiante().identity().value(), "El estudiante ya tiene inscrita esa materia");
        }
        estudiante.inscribirMateria(command.getAsignatura(),estudiante);
        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
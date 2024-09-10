package codeledge.backend_curso.Services;

import codeledge.backend_curso.Models.SeccionsModel;
import java.util.List;


public interface ISeccionsService {

    List<SeccionsModel> listarSeccions();
    SeccionsModel buscarSeccionPorId(Long id);
    SeccionsModel guardarSeccion(SeccionsModel seccions);
    void eliminarSeccionPorId(Long id);

}

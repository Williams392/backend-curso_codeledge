package codeledge.backend_curso.Services;

import codeledge.backend_curso.Models.SeccionsModel;
import codeledge.backend_curso.Repository.ISeccionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionsService implements ISeccionsService {

    @Autowired
    private ISeccionsRepository seccionsRepository;

    @Override
    public List<SeccionsModel> listarSeccions() {
        return seccionsRepository.findAll();
    }

    @Override
    public SeccionsModel buscarSeccionPorId(Long id) {
        return seccionsRepository.findById(id).orElse(null);
    }

    @Override
    public SeccionsModel guardarSeccion(SeccionsModel seccions) {
        return seccionsRepository.save(seccions);
    }

    @Override
    public void eliminarSeccionPorId(Long id) {
        seccionsRepository.deleteById(id);
    }
}

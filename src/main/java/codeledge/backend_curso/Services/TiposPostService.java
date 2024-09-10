package codeledge.backend_curso.Services;

import codeledge.backend_curso.Models.TiposPostModel;
import codeledge.backend_curso.Repository.ITiposPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TiposPostService implements ITiposPostService  {

    @Autowired
    private ITiposPostRepository tiposPostRepository;

    @Override
    public List<TiposPostModel> listarTiposPost() {
        return tiposPostRepository.findAll();
    }

    @Override
    public TiposPostModel buscarTipoPostPorId(Long id) {
        return tiposPostRepository.findById(id).orElse(null);
    }

    @Override
    public TiposPostModel guardarTipoPost(TiposPostModel tipoPost) {
        return tiposPostRepository.save(tipoPost);
    }

    @Override
    public void eliminarTipoPostPorId(Long id) {
        tiposPostRepository.deleteById(id);
    }
}

package codeledge.backend_curso.Services;

import codeledge.backend_curso.Models.DetallePostModel;
import codeledge.backend_curso.Repository.IDetallePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePostService implements IDetallePostService {

    @Autowired
    private IDetallePostRepository detallePostRepository;

    @Override
    public List<DetallePostModel> listarDetallesPost() {
        return detallePostRepository.findAll();
    }

    @Override
    public DetallePostModel buscarDetallePostPorId(Long id) {
        return detallePostRepository.findById(id).orElse(null);
    }

    @Override
    public DetallePostModel guardarDetallePost(DetallePostModel detallePost) {
        return detallePostRepository.save(detallePost);
    }

    @Override
    public void eliminarDetallePostPorId(Long id) {
        detallePostRepository.deleteById(id);
    }
}
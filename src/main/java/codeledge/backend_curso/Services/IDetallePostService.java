package codeledge.backend_curso.Services;
import codeledge.backend_curso.Models.DetallePostModel;
import java.util.List;

public interface IDetallePostService {

    List<DetallePostModel> listarDetallesPost();
    DetallePostModel buscarDetallePostPorId(Long id);
    DetallePostModel guardarDetallePost(DetallePostModel detallePost);
    void eliminarDetallePostPorId(Long id);

}

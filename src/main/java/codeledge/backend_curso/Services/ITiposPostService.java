package codeledge.backend_curso.Services;

import codeledge.backend_curso.Models.TiposPostModel;

import java.util.List;


public interface ITiposPostService {

    List<TiposPostModel> listarTiposPost();
    TiposPostModel buscarTipoPostPorId(Long id);
    TiposPostModel guardarTipoPost(TiposPostModel tipoPost);
    void eliminarTipoPostPorId(Long id);

}

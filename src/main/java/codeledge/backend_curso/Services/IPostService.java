package codeledge.backend_curso.Services;

import codeledge.backend_curso.Models.PostModel;
import java.util.List;

public interface IPostService {

    List<PostModel> listarPosts();
    PostModel buscarPostPorId(Long id);
    PostModel guardarPost(PostModel post);
    void eliminarPostPorId(Long id);
}

package codeledge.backend_curso.Services;

import codeledge.backend_curso.Models.PostModel;
import codeledge.backend_curso.Repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<PostModel> listarPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostModel buscarPostPorId(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public PostModel guardarPost(PostModel post) {
        return postRepository.save(post);
    }

    @Override
    public void eliminarPostPorId(Long id) {
        postRepository.deleteById(id);
    }
}

package codeledge.backend_curso.Controllers;

import codeledge.backend_curso.Models.PostModel;
import codeledge.backend_curso.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin(value = "http://localhost:4200")
public class PostController {

    @Autowired
    private PostService postServicio;

    @GetMapping("/posts")
    public List<PostModel> obtenerPosts() {
        return postServicio.listarPosts();
    }

    @PostMapping("/posts")
    public PostModel agregarPost(@RequestBody PostModel post) {
        return postServicio.guardarPost(post);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostModel> obtenerPostPorId(@PathVariable Long id) {
        PostModel post = postServicio.buscarPostPorId(id);
        if (post != null)
            return ResponseEntity.ok(post);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostModel> actualizarPost(@PathVariable Long id, @RequestBody PostModel postRecibido) {
        PostModel post = postServicio.buscarPostPorId(id);
        if (post == null)
            return ResponseEntity.notFound().build();

        post.setTitulo(postRecibido.getTitulo());
        post.setDescripcion(postRecibido.getDescripcion());
        post.setContenido(postRecibido.getContenido());
        post.setFecha_publicacion(postRecibido.getFecha_publicacion());
        post.setTipoPost(postRecibido.getTipoPost());

        postServicio.guardarPost(post);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPost(@PathVariable Long id) {
        PostModel post = postServicio.buscarPostPorId(id);
        if (post == null)
            return ResponseEntity.notFound().build();

        postServicio.eliminarPostPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

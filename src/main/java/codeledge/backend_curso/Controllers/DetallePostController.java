package codeledge.backend_curso.Controllers;

import codeledge.backend_curso.Models.DetallePostModel;
import codeledge.backend_curso.Services.DetallePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin(value = "http://localhost:4200")
public class DetallePostController {

    @Autowired
    private DetallePostService detallePostServicio;

    @GetMapping("/detalles_post")
    public List<DetallePostModel> obtenerDetallesPost() {
        return detallePostServicio.listarDetallesPost();
    }

    @PostMapping("/detalles_post")
    public DetallePostModel agregarDetallePost(@RequestBody DetallePostModel detallePost) {
        return detallePostServicio.guardarDetallePost(detallePost);
    }

    @GetMapping("/detalles_post/{id}")
    public ResponseEntity<DetallePostModel> obtenerDetallePostPorId(@PathVariable Long id) {
        DetallePostModel detallePost = detallePostServicio.buscarDetallePostPorId(id);
        if (detallePost != null)
            return ResponseEntity.ok(detallePost);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/detalles_post/{id}")
    public ResponseEntity<DetallePostModel> actualizarDetallePost(@PathVariable Long id, @RequestBody DetallePostModel detallePostRecibido) {
        DetallePostModel detallePost = detallePostServicio.buscarDetallePostPorId(id);
        if (detallePost == null)
            return ResponseEntity.notFound().build();

        detallePost.setTitulo(detallePostRecibido.getTitulo());
        detallePost.setDescripcion(detallePostRecibido.getDescripcion());
        detallePost.setContenido(detallePostRecibido.getContenido());
        detallePost.setUrl_recurso(detallePostRecibido.getUrl_recurso());
        detallePost.setPost(detallePostRecibido.getPost());
        detallePost.setPicture(detallePostRecibido.getPicture());

        detallePostServicio.guardarDetallePost(detallePost);
        return ResponseEntity.ok(detallePost);
    }

    @DeleteMapping("/detalles_post/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarDetallePost(@PathVariable Long id) {
        DetallePostModel detallePost = detallePostServicio.buscarDetallePostPorId(id);
        if (detallePost == null)
            return ResponseEntity.notFound().build();

        detallePostServicio.eliminarDetallePostPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

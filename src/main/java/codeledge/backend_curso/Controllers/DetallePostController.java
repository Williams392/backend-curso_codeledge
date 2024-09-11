package codeledge.backend_curso.Controllers;

import codeledge.backend_curso.Models.DetallePostModel;
import codeledge.backend_curso.Services.DetallePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<DetallePostModel> agregarDetallePost(
            @RequestParam("titulo") String titulo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("contenido") String contenido,
            @RequestParam("url_recurso") String urlRecurso,
            @RequestParam("imagen") MultipartFile imagen) {

        try {
            DetallePostModel detallePost = new DetallePostModel();
            detallePost.setTitulo(titulo);
            detallePost.setDescripcion(descripcion);
            detallePost.setContenido(contenido);
            detallePost.setUrl_recurso(urlRecurso);
            detallePost.setPicture(imagen.getBytes());

            DetallePostModel detalleGuardado = detallePostServicio.guardarDetallePost(detallePost);
            return ResponseEntity.ok(detalleGuardado);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
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
    public ResponseEntity<DetallePostModel> actualizarDetallePost(@PathVariable Long id,
                                                                  @RequestParam("titulo") String titulo,
                                                                  @RequestParam("descripcion") String descripcion,
                                                                  @RequestParam("contenido") String contenido,
                                                                  @RequestParam("url_recurso") String urlRecurso,
                                                                  @RequestParam("imagen") MultipartFile imagen) {

        DetallePostModel detallePost = detallePostServicio.buscarDetallePostPorId(id);
        if (detallePost == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            detallePost.setTitulo(titulo);
            detallePost.setDescripcion(descripcion);
            detallePost.setContenido(contenido);
            detallePost.setUrl_recurso(urlRecurso);
            detallePost.setPicture(imagen.getBytes());

            detallePostServicio.guardarDetallePost(detallePost);
            return ResponseEntity.ok(detallePost);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
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

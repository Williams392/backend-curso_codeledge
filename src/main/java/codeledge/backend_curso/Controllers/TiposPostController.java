package codeledge.backend_curso.Controllers;

import codeledge.backend_curso.Models.TiposPostModel;
import codeledge.backend_curso.Services.TiposPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin(value = "http://localhost:4200")
public class TiposPostController {

    @Autowired
    private TiposPostService tiposPostServicio;

    @GetMapping("/tipos_post")
    public List<TiposPostModel> obtenerTiposPost() {
        return tiposPostServicio.listarTiposPost();
    }

    @PostMapping("/tipos_post")
    public TiposPostModel agregarTipoPost(@RequestBody TiposPostModel tipoPost) {
        return tiposPostServicio.guardarTipoPost(tipoPost);
    }

    @GetMapping("/tipos_post/{id}")
    public ResponseEntity<TiposPostModel> obtenerTipoPostPorId(@PathVariable Long id) {
        TiposPostModel tipoPost = tiposPostServicio.buscarTipoPostPorId(id);
        if (tipoPost != null)
            return ResponseEntity.ok(tipoPost);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/tipos_post/{id}")
    public ResponseEntity<TiposPostModel> actualizarTipoPost(@PathVariable Long id, @RequestBody TiposPostModel tipoPostRecibido) {
        TiposPostModel tipoPost = tiposPostServicio.buscarTipoPostPorId(id);
        if (tipoPost == null)
            return ResponseEntity.notFound().build();

        tipoPost.setNombre_tipo(tipoPostRecibido.getNombre_tipo());
        tipoPost.setDescripcion(tipoPostRecibido.getDescripcion());

        tiposPostServicio.guardarTipoPost(tipoPost);
        return ResponseEntity.ok(tipoPost);
    }

    @DeleteMapping("/tipos_post/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarTipoPost(@PathVariable Long id) {
        TiposPostModel tipoPost = tiposPostServicio.buscarTipoPostPorId(id);
        if (tipoPost == null)
            return ResponseEntity.notFound().build();

        tiposPostServicio.eliminarTipoPostPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

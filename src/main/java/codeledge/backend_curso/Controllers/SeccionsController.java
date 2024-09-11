package codeledge.backend_curso.Controllers;

import codeledge.backend_curso.Models.SeccionsModel;
import codeledge.backend_curso.Services.SeccionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin(value = "http://localhost:4200")
public class SeccionsController {

    @Autowired
    private SeccionsService seccionsServicio;

    @GetMapping("/seccions")
    public List<SeccionsModel> obtenerSeccions() {
        return seccionsServicio.listarSeccions();
    }

    @PostMapping("/seccions")
    public SeccionsModel agregarSeccion(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("code") String code,
            @RequestParam("orden") Long orden,
            @RequestParam("contenidoMarkdown") String contenidoMarkdown,
            @RequestParam(value = "picture", required = false) MultipartFile picture
    ) throws IOException {
        SeccionsModel seccion = new SeccionsModel();
        seccion.setNombre(nombre);
        seccion.setDescripcion(descripcion);
        seccion.setCode(code);
        seccion.setOrden(orden);
        seccion.setContenidoMarkdown(contenidoMarkdown);

        // Verifica si hay una imagen enviada
        if (picture != null && !picture.isEmpty()) {
            seccion.setPicture(picture.getBytes());
        }

        return seccionsServicio.guardarSeccion(seccion);
    }

    @GetMapping("/seccions/{id}")
    public ResponseEntity<SeccionsModel> obtenerSeccionPorId(@PathVariable Long id) {
        SeccionsModel seccion = seccionsServicio.buscarSeccionPorId(id);
        if (seccion != null)
            return ResponseEntity.ok(seccion);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/seccions/{id}")
    public ResponseEntity<SeccionsModel> actualizarSeccion(
            @PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("code") String code,
            @RequestParam("orden") Long orden,
            @RequestParam("contenidoMarkdown") String contenidoMarkdown,
            @RequestParam(value = "picture", required = false) MultipartFile picture
    ) throws IOException {
        SeccionsModel seccion = seccionsServicio.buscarSeccionPorId(id);
        if (seccion == null)
            return ResponseEntity.notFound().build();

        seccion.setNombre(nombre);
        seccion.setDescripcion(descripcion);
        seccion.setCode(code);
        seccion.setOrden(orden);
        seccion.setContenidoMarkdown(contenidoMarkdown);

        // Verifica si hay una nueva imagen para actualizar
        if (picture != null && !picture.isEmpty()) {
            seccion.setPicture(picture.getBytes());
        }

        seccionsServicio.guardarSeccion(seccion);
        return ResponseEntity.ok(seccion);
    }

    @DeleteMapping("/seccions/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarSeccion(@PathVariable Long id) {
        SeccionsModel seccion = seccionsServicio.buscarSeccionPorId(id);
        if (seccion == null)
            return ResponseEntity.notFound().build();

        seccionsServicio.eliminarSeccionPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

package codeledge.backend_curso.Controllers;

import codeledge.backend_curso.Models.SeccionsModel;
import codeledge.backend_curso.Services.SeccionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public SeccionsModel agregarSeccion(@RequestBody SeccionsModel seccion) {
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
    public ResponseEntity<SeccionsModel> actualizarSeccion(@PathVariable Long id, @RequestBody SeccionsModel seccionRecibida) {
        SeccionsModel seccion = seccionsServicio.buscarSeccionPorId(id);
        if (seccion == null)
            return ResponseEntity.notFound().build();

        seccion.setNombre(seccionRecibida.getNombre());
        seccion.setDescripcion(seccionRecibida.getDescripcion());
        seccion.setCode(seccionRecibida.getCode());
        seccion.setOrden(seccionRecibida.getOrden());
        seccion.setDetallepost(seccionRecibida.getDetallepost());
        seccion.setPicture(seccionRecibida.getPicture());
        seccion.setContenidoMarkdown(seccionRecibida.getContenidoMarkdown());

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

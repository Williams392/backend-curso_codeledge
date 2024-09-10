package codeledge.backend_curso.Models;

import jakarta.persistence.*;

public class DetallePostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_detallepost;

    private String titulo;
    private String descripcion;
    private String contenido;
    private String url_recurso;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private PostModel post;

}

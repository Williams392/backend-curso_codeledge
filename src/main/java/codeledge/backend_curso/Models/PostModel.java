package codeledge.backend_curso.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "post_tb")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_post;

    private String titulo;
    private String descripcion;
    private String contenido;
    private Date fecha_publicacion;

    @ManyToOne
    @JoinColumn(name = "tipo_post_id")
    private TiposPostModel tipoPost;

}

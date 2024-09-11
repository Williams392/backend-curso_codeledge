package codeledge.backend_curso.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detallePost_tb")
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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column( name ="picture", columnDefinition = "longblob")
    @JsonIgnore
    private byte[] picture;

}

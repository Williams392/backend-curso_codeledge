package codeledge.backend_curso.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seccions_tb")
public class SeccionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_seccion;

    private String nombre;
    private String descripcion;
    private String code;
    private long orden;

    @ManyToOne
    @JoinColumn(name = "id_detallepost")
    private DetallePostModel detallepost;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column( name ="picture", columnDefinition = "longblob")
    private byte[] picture;

    @Lob
    @Column(name = "contenido_markdown")
    private String contenidoMarkdown; // Campo para almacenar Markdown

}




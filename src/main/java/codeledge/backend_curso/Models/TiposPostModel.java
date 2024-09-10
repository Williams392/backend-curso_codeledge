package codeledge.backend_curso.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tiposPost_tb")
public class TiposPostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipo_post;

    private String nombre_tipo;
    private String descripcion;
}

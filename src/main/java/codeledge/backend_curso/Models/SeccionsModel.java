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
    private Integer id_seccion;

    private String nombre;
    private String descripcion;
    private Integer orden;
}

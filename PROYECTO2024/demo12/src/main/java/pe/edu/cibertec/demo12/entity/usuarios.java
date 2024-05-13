package pe.edu.cibertec.demo12.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class usuarios {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idusuario;
    private Integer idempleado;
    private String usuario;
    private String contrasenia;

}


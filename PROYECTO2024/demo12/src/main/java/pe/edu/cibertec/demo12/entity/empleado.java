package pe.edu.cibertec.demo12.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class empleado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer idempleado;
    private String nombre ;
    private String apellido;
    private String email;
    private String telefono;
    private String cargo;
}
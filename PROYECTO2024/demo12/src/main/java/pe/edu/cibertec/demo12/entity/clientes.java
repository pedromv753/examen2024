package pe.edu.cibertec.demo12.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class clientes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idcliente;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<ventas> ventas;
}

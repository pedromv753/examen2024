package pe.edu.cibertec.demo12.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name="ventas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ventas {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idventa;
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private clientes cliente;
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private productos producto;
    private Date fechaventa;
    private Integer cantidad;
    private boolean preciototal;
}

package pe.edu.cibertec.demo12.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="inventario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class inventario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idinventario;
    private Integer idproducto;
    private Integer idproveedor;
    private Date fechaingreso;
    private Integer cantidad;
    private boolean preciocompra;
}

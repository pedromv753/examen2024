package pe.edu.cibertec.demo12.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="proveedores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class proveedores {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idproveedor;
    private String nombreempresa;
    private String contacto;
    private String telefono;
    private String email;
    private String direccion;

    @ManyToMany
    @JoinTable(
            name = "inventario",
            joinColumns = @JoinColumn(name = "idproveedor"),
            inverseJoinColumns = @JoinColumn(name = "idproducto")
    )
    private List<productos> productos;
}


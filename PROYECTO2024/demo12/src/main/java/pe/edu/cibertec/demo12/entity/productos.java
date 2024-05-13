package pe.edu.cibertec.demo12.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class productos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idproducto;
    private String nombre;
    private String marca;
    private String modelo;
    private boolean precio;
    private Integer stock;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<ventas> ventas;

    @ManyToMany(mappedBy = "productos")
    @JsonIgnore
    private List<proveedores> proveedores;
}

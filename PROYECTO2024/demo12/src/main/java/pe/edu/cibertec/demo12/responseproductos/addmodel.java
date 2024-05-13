package pe.edu.cibertec.demo12.responseproductos;
import pe.edu.cibertec.demo12.entity.productos;
public record addmodel(String code, String error, Iterable<productos>product) {
}

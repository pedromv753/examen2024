package pe.edu.cibertec.demo12.responseventas;
import pe.edu.cibertec.demo12.entity.ventas;
public record addmodel(String code, String error, Iterable<ventas>venta) {
}

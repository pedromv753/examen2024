package pe.edu.cibertec.demo12.responseinventario;
import pe.edu.cibertec.demo12.entity.inventario;
public record addmodel(String code, String error, Iterable<inventario>inventario) {
}

package pe.edu.cibertec.demo12.responseproveeedores;
import pe.edu.cibertec.demo12.entity.proveedores;
public record addmodel(String code, String error, Iterable<proveedores>proveedores) {
}

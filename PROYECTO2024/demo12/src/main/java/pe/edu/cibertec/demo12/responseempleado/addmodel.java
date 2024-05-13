package pe.edu.cibertec.demo12.responseempleado;
import pe.edu.cibertec.demo12.entity.empleado;
public record addmodel(String code, String error, Iterable<empleado>empleados) {
}

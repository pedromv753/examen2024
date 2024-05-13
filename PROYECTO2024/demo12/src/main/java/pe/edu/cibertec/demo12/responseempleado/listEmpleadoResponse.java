package pe.edu.cibertec.demo12.responseempleado;

import pe.edu.cibertec.demo12.entity.empleado;

public record listEmpleadoResponse(String codigo, String mensaje, Iterable<empleado> empleados)  {
}

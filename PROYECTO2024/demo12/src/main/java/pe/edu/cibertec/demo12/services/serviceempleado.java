package pe.edu.cibertec.demo12.services;

import pe.edu.cibertec.demo12.entity.empleado;
import pe.edu.cibertec.demo12.interfaces.interfacesempleado;
import pe.edu.cibertec.demo12.responseempleado.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class serviceempleado {


        @Autowired
        private interfacesempleado interfacess;

        @PostMapping("/Add")
        public addresponse Add(@RequestBody empleado empleado) {
            if (empleado.getIdempleado() != null) {
                return new addresponse("99", "id parameter not allowed");
            }
            interfacess.save(empleado);
            return new addresponse("01", "null");

        }

        @GetMapping("/all")
        public listEmpleadoResponse ADD(@RequestParam(value = "id", defaultValue = "0")Integer id) {
            Iterable<empleado> empleados = null;
            if (id>0) {
                empleados = interfacess.findAllById(List.of(id));
                return new listEmpleadoResponse("01",null, empleados);
            } else {
                empleados = interfacess.findAll();
                return new listEmpleadoResponse("01",null, empleados);
            }

        }


        @PostMapping("/update")
        public addupdate updateModel(@RequestBody empleado empleados) {
            if (!interfacess.findById(empleados.getIdempleado()).isPresent()) {
                return new addupdate("99", "User not found");
            }
            interfacess.save(empleados);
            return new addupdate("01", "null");
        }

        @PostMapping("/Delete")
        public addDelete DeleteModel(@RequestBody empleado empleados) {
            if (!interfacess.findById(empleados.getIdempleado()).isPresent()) {
                return new addDelete("99", "auto not found");
            }
            interfacess.delete(empleados);
            return new addDelete("01", "null");

        }
    }


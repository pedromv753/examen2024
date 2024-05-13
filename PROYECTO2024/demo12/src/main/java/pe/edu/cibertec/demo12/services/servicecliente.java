package pe.edu.cibertec.demo12.services;

import pe.edu.cibertec.demo12.responsecliente.*;
import pe.edu.cibertec.demo12.interfaces.interfacesclientes;
import pe.edu.cibertec.demo12.entity.clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class servicecliente {

    @Autowired
    private interfacesclientes interfacess;

    @PostMapping("/Add")
    public addresponse Add(@RequestBody clientes Clientes) {
        if (Clientes.getIdcliente() != null) {
            return new addresponse("99", "id parameter not allowed");
        }
        interfacess.save(Clientes);
        return new addresponse("01", "null");

    }

    @GetMapping("/all")
    public addmodel ADD(@RequestParam(value = "id", defaultValue = "0")Integer id) {
        Iterable<clientes> Clientes = null;
        if (id>0) {
            Clientes = interfacess.findAllById(List.of(id));
        } else {
            Clientes = interfacess.findAll();
        }

        return new addmodel("01",null,Clientes);
    }


    @PostMapping("/update")
    public addupdate updateModel(@RequestBody clientes Clientes) {
        if (!interfacess.findById(Clientes.getIdcliente()).isPresent()) {
            return new addupdate("99", "User not found");
        }
        interfacess.save(Clientes);
        return new addupdate("01", "null");
    }

    @PostMapping("/Delete")
    public addDelete DeleteModel(@RequestBody clientes Clientes) {
        if (!interfacess.findById(Clientes.getIdcliente()).isPresent()) {
            return new addDelete("99", "auto not found");
        }
        interfacess.delete(Clientes);
        return new addDelete("01", "null");

    }
}



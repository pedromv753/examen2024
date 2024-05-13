package pe.edu.cibertec.demo12.services;


import pe.edu.cibertec.demo12.entity.inventario;
import pe.edu.cibertec.demo12.interfaces.interfacesinventario;
import pe.edu.cibertec.demo12.responseinventario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class serviceinventario {

    @Autowired
    private interfacesinventario interfacess;

    @PostMapping("/Add")
    public addresponse Add(@RequestBody inventario inventario) {
        if (inventario.getIdproveedor() != null) {
            return new addresponse("99", "id parameter not allowed");
        }
        interfacess.save(inventario);
        return new addresponse("01", "null");

    }

    @GetMapping("/all")
    public addmodel ADD(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<inventario> inventario = null;
        if (id > 0) {
            inventario = interfacess.findAllById(List.of(id));
        } else {
            inventario = interfacess.findAll();
        }

        return new addmodel("01", null, inventario);
    }


    @PostMapping("/update")
    public addupdate updateModel(@RequestBody inventario inventario) {
        if (!interfacess.findById(inventario.getIdproveedor()).isPresent()) {
            return new addupdate("99", "User not found");
        }
        interfacess.save(inventario);
        return new addupdate("01", "null");
    }

    @PostMapping("/Delete")
    public addDelete DeleteModel(@RequestBody inventario inventario) {
        if (!interfacess.findById(inventario.getIdproveedor()).isPresent()) {
            return new addDelete("99", "auto not found");
        }
        interfacess.delete(inventario);
        return new addDelete("01", "null");

    }

}


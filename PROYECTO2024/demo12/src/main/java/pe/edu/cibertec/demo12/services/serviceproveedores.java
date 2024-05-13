package pe.edu.cibertec.demo12.services;

import pe.edu.cibertec.demo12.responseproveeedores.*;
import pe.edu.cibertec.demo12.entity.proveedores;
import pe.edu.cibertec.demo12.interfaces.interfacesproveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


    @RestController
    @RequestMapping("/proveedores")
    public class serviceproveedores {

        @Autowired
        private interfacesproveedores interfacess;

        @PostMapping("/Add")
        public addresponse Add(@RequestBody proveedores proveedores) {
            if (proveedores.getIdproveedor() != null) {
                return new addresponse("99", "id parameter not allowed");
            }
            interfacess.save(proveedores);
            return new addresponse("01", "null");

        }

        @GetMapping("/all")
        public addmodel ADD(@RequestParam(value = "id", defaultValue = "0")Integer id) {
            Iterable<proveedores> proveedores = null;
            if (id>0) {
                proveedores = interfacess.findAllById(List.of(id));
            } else {
                proveedores= interfacess.findAll();
            }

            return new addmodel("01",null,proveedores);
        }


        @PostMapping("/update")
        public addupdate updateModel(@RequestBody proveedores proveedores) {
            if (!interfacess.findById(proveedores.getIdproveedor()).isPresent()) {
                return new addupdate("99", "User not found");
            }
            interfacess.save(proveedores);
            return new addupdate("01", "null");
        }

        @PostMapping("/Delete")
        public addDelete DeleteModel(@RequestBody proveedores proveedores) {
            if (!interfacess.findById(proveedores.getIdproveedor()).isPresent()) {
                return new addDelete("99", "auto not found");
            }
            interfacess.delete(proveedores);
            return new addDelete("01", "null");

        }
    }


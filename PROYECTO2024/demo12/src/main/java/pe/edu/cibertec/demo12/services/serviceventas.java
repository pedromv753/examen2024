package pe.edu.cibertec.demo12.services;

import pe.edu.cibertec.demo12.entity.ventas;
import pe.edu.cibertec.demo12.interfaces.interfacesventas;
import pe.edu.cibertec.demo12.responseventas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


    @RestController
    @RequestMapping("/ventas")
    public class serviceventas {

        @Autowired
        private interfacesventas interfacess;

        @PostMapping("/Add")
        public addresponse Add(@RequestBody ventas ventas) {
            if (ventas.getIdventa() != null) {
                return new addresponse("99", "id parameter not allowed");
            }
            interfacess.save(ventas);
            return new addresponse("01", "null");

        }

        @GetMapping("/all")
        public addmodel ADD(@RequestParam(value = "id", defaultValue = "0") Integer id) {
            Iterable<ventas> ventas = null;
            if (id > 0) {
                ventas = interfacess.findAllById(List.of(id));
            } else {
                ventas = interfacess.findAll();
            }

            return new addmodel("01", null, ventas);
        }


        @PostMapping("/update")
        public addupdate updateModel(@RequestBody ventas ventas) {
            if (!interfacess.findById(ventas.getIdventa()).isPresent()) {
                return new addupdate("99", "User not found");
            }
            interfacess.save(ventas);
            return new addupdate("01", "null");
        }

        @PostMapping("/Delete")
        public addDelete DeleteModel(@RequestBody ventas ventas) {
            if (!interfacess.findById(ventas.getIdventa()).isPresent()) {
                return new addDelete("99", "auto not found");
            }
            interfacess.delete(ventas);
            return new addDelete("01", "null");

        }

    }

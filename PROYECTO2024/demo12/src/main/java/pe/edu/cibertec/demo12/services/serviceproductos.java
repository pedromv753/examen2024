package pe.edu.cibertec.demo12.services;


import pe.edu.cibertec.demo12.entity.productos;
import pe.edu.cibertec.demo12.interfaces.interfacesproductos;
import pe.edu.cibertec.demo12.responseproductos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@RestController
@RequestMapping("/productos")
public class serviceproductos {



        @Autowired
        private interfacesproductos interfacess;

        @PostMapping("/Add")
        public addresponse Add(@RequestBody productos product) {
            if (product.getIdproducto() != null) {
                return new addresponse("99", "id parameter not allowed");
            }
            interfacess.save(product);
            return new addresponse("01", "null");

        }

        @GetMapping("/all")
        public addmodel ADD(@RequestParam(value = "id", defaultValue = "0")Integer id) {
            Iterable<productos> productos = null;
            if (id>0) {
                productos = interfacess.findAllById(List.of(id));
            } else {
                productos= interfacess.findAll();
            }

            return new addmodel("01",null,productos);
        }


        @PostMapping("/update")
        public addupdate updateModel(@RequestBody productos productos) {
            if (!interfacess.findById(productos.getIdproducto()).isPresent()) {
                return new addupdate("99", "User not found");
            }
            interfacess.save(productos);
            return new addupdate("01", "null");
        }

        @PostMapping("/Delete")
        public addDelete DeleteModel(@RequestBody productos productos) {
            if (!interfacess.findById(productos.getIdproducto()).isPresent()) {
                return new addDelete("99", "auto not found");
            }
            interfacess.delete(productos);
            return new addDelete("01", "null");

        }
    }


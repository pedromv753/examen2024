package pe.edu.cibertec.demo12.interfaces;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.demo12.entity.usuarios;

public interface interfacesusuario extends CrudRepository<usuarios, Integer> {

    usuarios findByUsuario(String usuario);

}



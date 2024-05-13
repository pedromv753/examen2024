package pe.edu.cibertec.demo12.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.demo12.entity.usuarios;
import pe.edu.cibertec.demo12.interfaces.interfacesusuario;
import pe.edu.cibertec.demo12.responseusuario.addlogin;
import pe.edu.cibertec.demo12.security.JWTAuthenticationConfig;

@RestController
@RequestMapping("/usuarios")
public class serviceusuario {

    @Autowired
    private interfacesusuario userRepo;

    @Autowired
    private JWTAuthenticationConfig AutenticationCfg;

    @PostMapping("/login")
    public addlogin login(@RequestBody usuarios usuarios) {
      usuarios userResult = userRepo.findByUsuario(usuarios.getUsuario());
        if (userResult == null) {
            return new addlogin("85","not faull",null);
        }
        if (new BCryptPasswordEncoder().matches(usuarios.getContrasenia(), userResult.getContrasenia())) {
            return new addlogin("99","Password not found",null);
        }

        String token = AutenticationCfg.getJWTToken(usuarios.getUsuario());
        return  new addlogin("01",null,token);
    }
}



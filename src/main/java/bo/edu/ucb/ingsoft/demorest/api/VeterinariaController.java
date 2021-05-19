package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionVeterinaria;
import bo.edu.ucb.ingsoft.demorest.dao.VeterinariaDao;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;


@RestController
public class VeterinariaController {

    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionVeterinaria gestionVeterinaria;
    private Object Integer;


    @PostMapping(path = "/establecimiento")
    public ResponseDto crearVeterinaria(@RequestBody Veterinaria veterinaria) {

        if (veterinaria.getNombre() == null || veterinaria.getNombre().equals("")) {
            return new ResponseDto(false,null,"El nombre debe ser obligatorio");

        }
        if (veterinaria.getCiudad() == null || veterinaria.getCiudad().equals("")) {
            return new ResponseDto(false,null,"El apellido debe ser obligatorio");
        }
        if (veterinaria.getDireccion() == null || veterinaria.getDireccion().equals("")) {
            return new ResponseDto(false,null,"La direccion debe ser obligatorio");
        }
        if (veterinaria.getTelefono()== null || veterinaria.getTelefono().equals("")) {
            return new ResponseDto(false,null,"El telefono debe ser obligatorio");
        }
        if (veterinaria.getEmail()== null || veterinaria.getEmail().equals("")) {
            return new ResponseDto(false,null,"Email debe ser obligatorio");
        }
        if (veterinaria.getHoraAtencion() == null || veterinaria.getHoraAtencion().equals("")) {
            return new ResponseDto(false,null,"El horario de atencion debe ser obligatorio");
        }

        return new ResponseDto(true,gestionVeterinaria.crearVeterinaria(veterinaria),null);
    }

    @GetMapping(path = "/establecimiento")
    public ResponseDto findAllVeterinaria(){
        return new ResponseDto(true,gestionVeterinaria.findAllVeterinaria(),null);


    }

    }

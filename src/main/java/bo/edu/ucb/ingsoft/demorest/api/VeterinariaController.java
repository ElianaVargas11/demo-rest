package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionVeterinaria;
import bo.edu.ucb.ingsoft.demorest.dao.VeterinariaDao;
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
    public Veterinaria crearVeterinaria(@RequestBody Veterinaria veterinaria) {

        if (veterinaria.nombre == null || veterinaria.nombre.equals("")) {

        }
        if (veterinaria.ciudad == null || veterinaria.ciudad.equals("")) {

        }
        if (veterinaria.direccion == null || veterinaria.direccion.equals("")) {

        }
        if (veterinaria.telefono == null || veterinaria.telefono.equals("")) {

        }
        if (veterinaria.email == null || veterinaria.email.equals("")) {

        }
        if (veterinaria.horaAtencion == null || veterinaria.horaAtencion.equals("")) {

        }

        return gestionVeterinaria.crearVeterinaria(veterinaria);
    }

    @GetMapping(path = "/establecimiento")
    public List<Veterinaria> findAllVeterinaria(){
        return gestionVeterinaria.findAllVeterinaria();
    }

    }

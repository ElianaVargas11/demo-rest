package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionVeterinaria;
import bo.edu.ucb.ingsoft.demorest.bl.GestionVeterinario;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;
import java.util.List;

public class VeterinarioController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionVeterinario gestionVeterinario;
    private Object Integer;
    @GetMapping(path = "/veterinario/{idVeterinario}")
    public Veterinario findVeterinarioById(@PathVariable Integer idVeterinario){
        return gestionVeterinario.findVeterinarioById(idVeterinario);
    }
}

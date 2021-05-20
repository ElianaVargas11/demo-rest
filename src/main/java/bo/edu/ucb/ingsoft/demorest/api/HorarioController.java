package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionHorario;
import bo.edu.ucb.ingsoft.demorest.bl.GestionVeterinario;
import bo.edu.ucb.ingsoft.demorest.dto.Horario;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HorarioController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionHorario gestionHorario;

    @GetMapping(path = "/horario/{idVeterinario}")
    public ResponseDto findHorarioById(@PathVariable Integer idVeterinario){
       Horario horario = gestionHorario.findHorarioById(idVeterinario);
        if(horario !=null){
            return new ResponseDto(true,horario,null);
        }else {
            return new ResponseDto(false,null,"No existe veterinario con el codigo");

        }
    }
}

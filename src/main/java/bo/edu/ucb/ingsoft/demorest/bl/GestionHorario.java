package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.HorarioDao;
import bo.edu.ucb.ingsoft.demorest.dto.Horario;
import bo.edu.ucb.ingsoft.demorest.dto.Tips;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionHorario {

     @Autowired
    HorarioDao horarioDao;

    public Horario findHorarioById(Integer idVeterinario){
        return horarioDao.findHorarioById(idVeterinario);
    }
}

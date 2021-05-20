package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.VeterinariaDao;

import bo.edu.ucb.ingsoft.demorest.dao.VeterinarioDao;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GestionVeterinario {
    @Autowired
    VeterinarioDao veterinarioDao;

    public Veterinario findVeterinarioById(Integer idVeterinario){
        return veterinarioDao.findVeterinarioById(idVeterinario);
    }
}

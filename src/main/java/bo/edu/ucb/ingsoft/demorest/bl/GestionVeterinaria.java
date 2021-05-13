package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.VeterinariaDao;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionVeterinaria {

    @Autowired
    VeterinariaDao veterinariaDao;

    public Veterinaria crearVeterinaria(Veterinaria veterinaria){
        return veterinariaDao.crearVeterinaria(veterinaria);
    }
}

package bo.edu.ucb.ingsoft.demorest.dao;


import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Service
public class VeterinariaDao {
        @Autowired
        private DataSource dataSource;

        @Autowired
        private SecuenciaDao secuenciaDao;
     public Veterinaria crearVeterinaria (Veterinaria veterinaria){
          veterinaria.idEstablecimiento =secuenciaDao.getPrimaryKeyForTable("establecimiento");
         try{
             Connection conn =dataSource.getConnection();
             Statement stat = conn.createStatement();
             stat.execute("INSERT INTO establecimiento VALUES ("+veterinaria.idEstablecimiento+",'"+veterinaria.nombre+"','"+veterinaria.ciudad+"','"+veterinaria.direccion+"','"+veterinaria.telefono+"','"+veterinaria.email+"','"+veterinaria.horaAtencion+"')");
         }catch (Exception ex)
         {
             ex.printStackTrace();
         }

         return veterinaria;

     }


}

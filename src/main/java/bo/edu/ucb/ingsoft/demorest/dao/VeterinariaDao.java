package bo.edu.ucb.ingsoft.demorest.dao;


import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Service
public class VeterinariaDao {
        @Autowired
        public DataSource dataSource;
     public Veterinaria crearVeterinaria (Veterinaria veterinaria){
         try{
             Connection conn =dataSource.getConnection();
             Statement stat = conn.createStatement();
             stat.execute("INSERT INTO veterinaria VALUES ("+veterinaria.idVeterinaria+",'"+veterinaria.idTipo+"','"+veterinaria.nombre+"','"+veterinaria.ciudad+"','"+veterinaria.direccion+"','"+veterinaria.telefono+"','"+veterinaria.email+"','"+veterinaria.horaAtencion+"')");
         }catch (Exception ex)
         {
             ex.printStackTrace();
         }

         return veterinaria;

     }
}

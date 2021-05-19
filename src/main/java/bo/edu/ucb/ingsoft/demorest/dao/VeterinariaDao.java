package bo.edu.ucb.ingsoft.demorest.dao;


import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

     public List<Veterinaria> findAllVeterinaria(){
         List<Veterinaria> result = new ArrayList<>();

         try{
             Connection conn = dataSource.getConnection();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT id_establecimiento,nombre,ciudad,direccion,telefono,email,horario_atencion FROM establecimiento");
             while(rs.next()){
                 Veterinaria veterinaria = new Veterinaria();
                 veterinaria.idEstablecimiento = rs.getInt("id_establecimiento");
                 veterinaria.nombre = rs.getString("nombre");
                 veterinaria.ciudad = rs.getString("ciudad");
                 veterinaria.direccion = rs.getString("direccion");
                 veterinaria.telefono = rs.getString("telefono");
                 veterinaria.email = rs.getString("email");
                 veterinaria.horaAtencion = rs.getString("Horario_Atencion");
                 result.add(veterinaria);

             }
         }catch (Exception ex){
             ex.printStackTrace();
         }
         return result;
     }
}

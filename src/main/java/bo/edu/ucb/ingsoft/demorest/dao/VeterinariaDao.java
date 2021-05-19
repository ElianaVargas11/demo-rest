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
          veterinaria.setIdEstablecimiento(secuenciaDao.getPrimaryKeyForTable("establecimiento"));
         try{
             Connection conn =dataSource.getConnection();
             Statement stat = conn.createStatement();
             stat.execute("INSERT INTO establecimiento VALUES ("+veterinaria.getIdEstablecimiento()+",'"+veterinaria.getNombre()+"','"+veterinaria.getCiudad()+"','"+veterinaria.getDireccion()+"','"+veterinaria.getTelefono()+"','"+veterinaria.getEmail()+"','"+veterinaria.getHoraAtencion()+"')");
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
             ResultSet rs = stat.executeQuery("SELECT establecimiento_id,nombre,ciudad,direccion,telefono,email,horario_atencion FROM establecimiento");
             while(rs.next()){
                 Veterinaria veterinaria = new Veterinaria();
                 veterinaria.setIdEstablecimiento(rs.getInt("establecimiento_id"));
                 veterinaria.setNombre(rs.getString("nombre"));
                 veterinaria.setCiudad(rs.getString("ciudad"));
                 veterinaria.setDireccion(rs.getString("direccion"));
                 veterinaria.setTelefono(rs.getString("telefono"));
                 veterinaria.setEmail(rs.getString("email"));
                 veterinaria.setHoraAtencion(rs.getString("Horario_Atencion"));
                 result.add(veterinaria);

             }
         }catch (Exception ex){
             ex.printStackTrace();
         }
         return result;
     }
}

package bo.edu.ucb.ingsoft.demorest.dao;


import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import java.sql.*;
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
         Connection conn = null;
         try{
              conn = dataSource.getConnection();
              PreparedStatement pstmt = conn.prepareStatement("INSERT INTO establecimiento VALUES (?,?,?,?,?,?,?)");
              pstmt.setInt(1,veterinaria.getIdEstablecimiento());
              pstmt.setString(2, veterinaria.getNombre());
              pstmt.setString(3, veterinaria.getCiudad());
              pstmt.setString(4, veterinaria.getDireccion());
              pstmt.setString(5, veterinaria.getTelefono());
              pstmt.setString(6, veterinaria.getEmail());
              pstmt.setString(7, veterinaria.getHoraAtencion());
              pstmt.executeUpdate();
         }
         catch (Exception ex){
             ex.printStackTrace();
         }finally {
             if (conn != null){
                 try{
                     conn.close();
                 }catch (SQLException sqex){

                 }
             }
         }
         return veterinaria;
     }



     public List<Veterinaria> findAllVeterinaria(){
         List<Veterinaria> result = new ArrayList<>();

         try(Connection conn = dataSource.getConnection();
             Statement pstmt = conn.createStatement())
         {

             ResultSet rs = pstmt.executeQuery("SELECT establecimiento_id,nombre,ciudad,direccion,telefono,email,horario_atencion FROM establecimiento");
             while(rs.next())
             {
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
         }catch (Exception ex)
         {
             ex.printStackTrace();
         }
         return result;
     }
}

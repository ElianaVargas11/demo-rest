package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;
import ch.qos.logback.core.db.ConnectionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;


@Service
public class VeterinarioDao {

    @Autowired
    private DataSource dataSource;

    public Veterinario findVeterinarioById(Integer idVeterinario){
        Veterinario result = new Veterinario();
        try{
            Connection conn = dataSource.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT id_veterinario,id_usuario,id_veterinaria,id_imagen,nombre,apellido,email,departamento,lugar_formacion from veterinario"+"WHERE id_veterinario ="+idVeterinario);
            if(rs.next())
            {
                result.idVeterinario = rs.getInt("id_veterinario");
                result.nombre = rs.getString("id_usuario");
                result.apellido = rs.getString("id_veterinaria");
                result.apellido = rs.getString("id_imagen");
                result.apellido = rs.getString("nombre");
                result.apellido = rs.getString("apellido");
                result.apellido = rs.getString("email");
                result.apellido = rs.getString("departamento");
                result.apellido = rs.getString("lugar_formacion");
            }
                    }catch (Exception ex){
                     ex.printStackTrace();
        }
        return result;
    }
}

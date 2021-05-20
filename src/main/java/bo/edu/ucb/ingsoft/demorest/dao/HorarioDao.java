package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Horario;
import bo.edu.ucb.ingsoft.demorest.dto.Tips;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioDao {

    @Autowired
    private DataSource dataSource;
    public Horario findHorarioById(Integer idVeterinario){
        Horario result = new Horario();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select h.dia, concat(h.desde_hrs,' - ', h.hasta_hrs) HORARIO from  horario h where h.id_veterinario = ?"))
        {

            pstmt.setInt(1,idVeterinario);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                result.setDia(rs.getString("dia"));
                result.setHorario(rs.getString("horario"));

            }  else{
                result = null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}

package bo.edu.ucb.ingsoft.demorest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


@Service
public class SecuenciaDao {

    @Autowired
    private DataSource dataSource;

    public int getPrimaryKeyForTable (String nombreTabla){
        String nombreSecuencia = nombreTabla.toLowerCase()+"_"+nombreTabla.toLowerCase()+"_"+"id_seq";
        int resultado = 0;
        try(Connection conn =dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT nextval(?)"))
        {
            pstmt.setString(1,nombreSecuencia);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
               resultado = rs.getInt(1);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return resultado;
    }
}

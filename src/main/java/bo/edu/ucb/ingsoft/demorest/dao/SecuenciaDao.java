package bo.edu.ucb.ingsoft.demorest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

@Service
public class SecuenciaDao {
    @Autowired
    private DataSource dataSource;

    public int getPrimaryKeyForTable (String nombreTabla){
        String nombreSecuencia = nombreTabla.toLowerCase()+ "_"+"id"+"_"+nombreTabla.toLowerCase()+"_"+"seq";

        try{
            Connection conn =dataSource.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT nextval('"+nombreSecuencia+"')");
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return 0;
    }
}

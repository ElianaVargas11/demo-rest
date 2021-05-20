package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Tips;
import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
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
public class TipsDao {
    @Autowired
    private DataSource dataSource;

    public List<Tips> findAllTips(){
        List<Tips> result = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            Statement stat = conn.createStatement();)
        {

            ResultSet rs = stat.executeQuery("select t.titulo, t.descripcion, i.nombre_imagen from tips t join imagen i on t.id_imagen = i.id_imagen");

            while(rs.next()){
                Tips tips = new Tips();
                tips.setTitulo(rs.getString("titulo"));
                tips.setDescripcion(rs.getString("descripcion"));
                tips.setNombreImagen(rs.getString("nombre_imagen"));
                result.add(tips);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
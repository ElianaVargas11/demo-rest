package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Tips;

import bo.edu.ucb.ingsoft.demorest.dto.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipsDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecuenciaDao secuenciaDao;

    public List<Tips> findAllTips(){
        List<Tips> result = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            Statement stat = conn.createStatement())
        {

            ResultSet rs = stat.executeQuery("select t.titulo, t.descripcion, i.nombre_imagen, concat(v.nombre,' ',v.apellido) tip_veterinario from tips t join imagen i on t.id_imagen = i.id_imagen join veterinario v on t.id_veterinario = v.id_veterinario");

            while(rs.next()){
                Tips tips = new Tips();
                tips.setTitulo(rs.getString("Titulo"));
                tips.setDescripcion(rs.getString("Descripcion"));
                tips.setNombreImagen(rs.getString("Nombre_imagen"));
                tips.setTipVeterinario(rs.getString("Tip_veterinario"));
                result.add(tips);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }




}

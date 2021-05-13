package bo.edu.ucb.ingsoft.demorest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController

public class VeterinarioController {



        @Autowired
        public DataSource dataSource;

        @GetMapping(path = "/veterinario/{id_veterinario}")

        public Veterinario findVeterinarioById(@PathVariable Integer idVeterinario){
            Veterinario result = new Veterinario();
            try{
                Connection conn= dataSource.getConnection();
                Statement stat = conn.createStatement();
                ResultSet rs= stat.executeQuery("SELECT id_veterinario,id_usuario,id_veterinaria,id_imagen,nombre,apellido,email,departamento,lugar_formacion FROM veterinario WHERE id_veterinario="+idVeterinario);
                if(rs.next()){
                    result.idVeterinario=rs.getInt("id_veterinario");
                    result.idUsuario=rs.getInt("id_usuario");
                    result.idVeterinaria=rs.getInt("id_veterinaria");
                    result.idImagen=rs.getInt("id_imagen");
                    result.nombre=rs.getString("nombre");
                    result.apellido=rs.getString("apellido");
                    result.email=rs.getString("email");
                    result.departamento=rs.getString("departamento");
                    result.lugarFormacion=rs.getString("lugar_formacion");


                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return result;
        }
    }
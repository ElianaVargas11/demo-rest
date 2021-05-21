package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Veterinario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;


@Service
public class VeterinarioDao {

    @Autowired
    private DataSource dataSource;



    public Veterinario findVeterinarioById(Integer idVeterinario){
        Veterinario result = new Veterinario();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select v.id_veterinario,v.id_veterinario,v.nombre,v.apellido,(select avg(ca.calificacion) from CONSULTA co, CALIFICACION ca  WHERE co.id_veterinario = v.id_veterinario and co.id_consulta= ca.id_consulta ) estrellas, e.especialidad,v.departamento,v.email,vet.nombre Trabaja_con,vet.direccion from veterinario v left join veterinario_especialidad ve on v.id_veterinario = ve.id_veterinario left join especialidad e on ve.id_especialidad = e.id_especialidad  left join veterinaria vet on v.id_veterinaria = vet.id_veterinaria where v.id_usuario = ?"))
        {
            pstmt.setInt(1,idVeterinario);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                result.setIdVeterinario(rs.getInt("id_veterinario"));
                result.setNombre(rs.getString("nombre"));
                result.setApellido(rs.getString("apellido"));
                result.setEstrellas(rs.getString("estrellas"));
                result.setEspecialidad(rs.getString("especialidad"));
                result.setDepartamento(rs.getString("departamento"));
                result.setEmail(rs.getString("email"));
                result.setTrabajacon(rs.getString("trabaja_con"));
                result.setDireccion(rs.getString("direccion"));

            }  else{
                result = null;
            }
        }catch (Exception ex){
                     ex.printStackTrace();
        }
        return result;
    }





}

package bo.edu.ucb.ingsoft.demorest.dto;

public class Tips {

    private String titulo;
    private String descripcion;
    private String nombreImagen;
    private String tipVeterinario;

    public String getTipVeterinario() {
        return tipVeterinario;
    }

    public void setTipVeterinario(String tipVeterinario) {
        this.tipVeterinario = tipVeterinario;
    }

    public Tips(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
}

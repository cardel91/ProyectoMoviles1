package ni.edu.uca.proyectomoviles1;

/**
 * Created by Administrador on 26/10/2016.
 */
public class Persona {

    private String nombre;
    private int edad;
    private String correo;
    private int imagen;

    public Persona(){}

    public Persona (String nombre, int edad, String correo, int imagen){
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

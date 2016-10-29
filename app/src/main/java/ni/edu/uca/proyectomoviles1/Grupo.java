package ni.edu.uca.proyectomoviles1;

/**
 * Created by Administrador on 28/10/2016.
 */
public class Grupo {

    private int id;
    private String asignatura;
    private int cantidadEstudiantes;

    public Grupo(int id, String asignatura, int cantidadEstudiantes){
        this.id = id;
        this.asignatura = asignatura;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    @Override
    public String toString() {
        return asignatura + " " + id;
    }
}

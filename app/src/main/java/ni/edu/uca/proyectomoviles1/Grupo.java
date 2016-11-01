package ni.edu.uca.proyectomoviles1;

import com.orm.SugarRecord;

/**
 * Created by Administrador on 28/10/2016.
 */
public class Grupo extends SugarRecord {

//    private int id;
    private String asignatura;
    private int cantidadEstudiantes;

    public Grupo(int id, String asignatura, int cantidadEstudiantes){
        this.asignatura = asignatura;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public Grupo(){}


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
        return asignatura + " " + getId();
    }
}

package ni.edu.uca.proyectomoviles1;

import com.orm.SugarRecord;

/**
 * Created by Administrador on 28/10/2016.
 */
public class Grupo extends SugarRecord {

    private int idGrupo;
    private String asignatura;
    private int cantidadEstudiantes;

    public Grupo(int idGrupo, String asignatura, int cantidadEstudiantes){
        this.idGrupo = idGrupo;
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

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
}

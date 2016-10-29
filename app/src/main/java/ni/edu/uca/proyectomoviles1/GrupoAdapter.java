package ni.edu.uca.proyectomoviles1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrador on 28/10/2016.
 */
public class GrupoAdapter extends ArrayAdapter<Grupo> {

    private List<Grupo> listaGrupos;
    private Context contexto;

    public GrupoAdapter(Context context, int resource, List<Grupo> objects) {
        super(context, resource, objects);
        listaGrupos = objects;
        contexto = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_grupo, parent, false);
        TextView id = (TextView) convertView.findViewById(R.id.idGrupo);
        TextView asignatura = (TextView) convertView.findViewById(R.id.asignatura);
        TextView cantidad = (TextView) convertView.findViewById(R.id.cantidadEstudiantes);

        Grupo grupoActual = listaGrupos.get(position);
        id.setText(String.valueOf(grupoActual.getId()));
        asignatura.setText(grupoActual.getAsignatura());
        cantidad.setText(String.valueOf(grupoActual.getCantidadEstudiantes()));

        return convertView;
    }
}

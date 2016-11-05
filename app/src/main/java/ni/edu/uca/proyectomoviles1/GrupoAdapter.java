package ni.edu.uca.proyectomoviles1;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
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
    private SparseBooleanArray mSelectedItemsIds;
    private List<Grupo> listaGrupos;
    private Context contexto;

    public GrupoAdapter(Context context, int resource, List<Grupo> objects) {
        super(context, resource, objects);
        mSelectedItemsIds = new SparseBooleanArray();
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
        id.setText(String.valueOf(grupoActual.getIdGrupo()));
        asignatura.setText(grupoActual.getAsignatura());
        cantidad.setText(String.valueOf(grupoActual.getCantidadEstudiantes()));

        convertView
                .setBackgroundColor(mSelectedItemsIds.get(position) ? 0x9934B5E4
                        : Color.TRANSPARENT);

        return convertView;
    }

    public void setGrupos (List<Grupo> lista){
        this.listaGrupos = lista;
    }

    public void toggleSelection(int position){
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);

        notifyDataSetChanged();
    }

    public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
}

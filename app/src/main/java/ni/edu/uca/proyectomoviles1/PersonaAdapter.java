package ni.edu.uca.proyectomoviles1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrador on 26/10/2016.
 *
 * Adaptador para objetos de tipo persona
 */
public class PersonaAdapter extends ArrayAdapter<Persona> {

    List<Persona> personas;

    public PersonaAdapter(Context context, List<Persona> objects) {
        super(context, 0, objects);
        this.personas = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Se crea el layoutInflater desde el contexto del adaptador
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_persona,parent,false);
        TextView textView1 = (TextView) convertView.findViewById(R.id.textView);
        TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);
        TextView textView3 = (TextView) convertView.findViewById(R.id.textView3);
        TextView textView4 = (TextView) convertView.findViewById(R.id.textView4);

        //Obtenemos una persona de la lista segun su posición
        Persona persona = personas.get(position);

        //Llenamos los textViews con los datos de la persona
        textView1.setText(persona.getNombre());
        textView2.setText(String.valueOf(persona.getEdad()));
        textView3.setText(persona.getCorreo());
        textView4.setVisibility(View.GONE);
        return convertView;
    }

}

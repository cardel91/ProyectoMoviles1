package ni.edu.uca.proyectomoviles1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 26/10/2016.
 *
 * Nuevo fragmento que contendra una lista de objetos
 */
public class ListaFragment extends android.support.v4.app.Fragment{


    private ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.listView);


        //Declaramos objetos de un tipo especifico (Persona)
        Persona persona1 = new Persona("Carlos",25,"cardel91@gmail.com",R.mipmap.ic_launcher);
        Persona persona2 = new Persona("Myriam",24,"myriam@gmail.com",R.mipmap.ic_launcher);
        Persona persona3 = new Persona("Fernando",26,"fernando@gmail.com",R.mipmap.ic_launcher);
        Persona persona4 = new Persona("Julio",31,"julio@gmail.com",R.mipmap.ic_launcher);
        Persona persona5 = new Persona("Francisco",15,"francisco@gmail.com",R.mipmap.ic_launcher);
        Persona persona6 = new Persona("Marla",23,"marlap@gmail.com",R.mipmap.ic_launcher);

        //Crear una lista de Personas
        List<Persona> personaList = new ArrayList<>();
        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);
        personaList.add(persona4);
        personaList.add(persona5);
        personaList.add(persona6);

        ArrayAdapter<Persona> adapter = new ArrayAdapter<Persona>(getActivity(), android.R.layout.simple_list_item_1, personaList);

        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}

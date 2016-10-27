package ni.edu.uca.proyectomoviles1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ListView listView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /**Se crea la vista del fragment
         * Una vez creada la vista instanciamos nuestros elementos
         * a traves del objeto View que acabamos de crear.
         */
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

        //Adapter sencillo
        ArrayAdapter<Persona> adapter = new ArrayAdapter<Persona>(getActivity(), android.R.layout.simple_list_item_1, personaList);

        //Adapter personalizado

        PersonaAdapter personaAdapter = new PersonaAdapter(getActivity(), personaList);
        listView.setAdapter(personaAdapter);

        return view;

//        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

package ni.edu.uca.proyectomoviles1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EjemploFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EjemploFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EjemploFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView listaEjemplo;

    private OnFragmentInteractionListener mListener;

    public EjemploFragment() {
        // Required empty public constructor
    }

    /**
     * Declaramos el adapter como variable global
     */
    private GrupoAdapter adapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EjemploFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EjemploFragment newInstance(String param1, String param2) {
        EjemploFragment fragment = new EjemploFragment();
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


//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        List<Grupo> grupos = Grupo.listAll(Grupo.class);
//        adapter.setGrupos(grupos);
//        adapter.notifyDataSetChanged();
//
//    }

    @Override
    public void onResume() {
        super.onResume();
        List<Grupo> grupos = Grupo.listAll(Grupo.class);
        adapter.setGrupos(grupos);
        adapter.notifyDataSetChanged();
        listaEjemplo.setAdapter(adapter);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ejemplo, container, false);

        listaEjemplo = (ListView) view.findViewById(R.id.listaEjemplo);
        Button button  = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NuevoGrupoActivity.class);
//                startActivity(intent);
                startActivity(intent);
            }
        });

        /**
         * Iniciar poblacion de listView
         */
        Grupo grupo1 = new Grupo(0120,"Desarrollo de Aplicaciones Moviles 1",28);
        Grupo grupo2 = new Grupo(0125,"Desarrollo de Aplicaciones Moviles 1", 24);
        Grupo grupo3 = new Grupo(0126,"Electiva",29);

        List<Grupo> listaGrupos = new ArrayList<>();

        listaGrupos = Grupo.listAll(Grupo.class);
//        listaGrupos.add(grupo1);
//        listaGrupos.add(grupo2);
//        listaGrupos.add(grupo3);
        /**
         * Declaramos un adapter sencillo
         */
        //ArrayAdapter<Grupo> adapter = new ArrayAdapter<Grupo>(getActivity(),android.R.layout.simple_list_item_1, listaGrupos);

        adapter = new GrupoAdapter(getActivity(),0,listaGrupos);
        /**
         * Seteamos el adapter en la listView
         */

        listaEjemplo.setAdapter(adapter);

        listaEjemplo.setLongClickable(true);
        listaEjemplo.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL); //Prueba de elementos de selección multiple en la lista
        listaEjemplo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick (AdapterView<?> parent, View view, int position, long id) {
                Grupo grupoSeleccionado = adapter.getItem(position);
                Toast.makeText(getActivity(),grupoSeleccionado.getAsignatura(),Toast.LENGTH_LONG).show();
                //startActionMode(modeCallBack);
                view.setSelected(true);
                return true;
            }
        });

        listaEjemplo.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            private MenuItem mMenuItemEdit;
            private int nr = 0;

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
//                mode.setTitle();
                if (checked) {
                    nr++;
                    adapter.toggleSelection(position);
                } else {
                    nr--;
                    adapter.toggleSelection(position);
                }
                mode.setTitle( nr + "seleccionado");
//                selectedListIndex = position;
                if(nr == 1){
                    mMenuItemEdit.setVisible(true);
                } else{
                    mMenuItemEdit.setVisible(false);
                }
            }


            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        SparseBooleanArray selected = adapter.getSelectedIds();
                        for(int i = selected.size()-1;i>=0;i--){
                            if(selected.valueAt(i)){
                                Grupo selectedList = adapter.getItem(selected.keyAt(i));
                                for(Grupo g : Grupo.find(
                                        Grupo.class,"id = ?",String.valueOf(
                                                selectedList.getId()))){
                                    g.delete();
                                }
                                selectedList.delete();
                                adapter.remove(selectedList);
                            }
                        }
                        if(adapter.getCount() == 0)
//                            toggleList(OFF);
                        mode.finish();
                        return true;
//                    case R.id.action_edit:
//                        mode.finish();
//                        onItemEdit(selectedListIndex);
//                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                nr = 0;
                MenuInflater inflater = getActivity().getMenuInflater();
                inflater.inflate(R.menu.menu_main_menu, menu);
                menu.findItem(R.id.action_settings).setTitle("Eliminar");
                mMenuItemEdit =  menu.findItem(R.id.action_settings);
                mMenuItemEdit.setVisible(false);
                return true;
            }
        });
        return view;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}

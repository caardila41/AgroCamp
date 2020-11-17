package com.ard.agrocampo.FragmentsProcesos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ard.agrocampo.CRUD.CRUDTarea;
import com.ard.agrocampo.Clases.Fecha;
import com.ard.agrocampo.Clases.Tarea;
import com.ard.agrocampo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TareasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TareasFragment extends Fragment implements AdapterView.OnItemLongClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

     private ListView listView;
     private ArrayAdapter<String> adapter;
     private  Fecha fecha;
     CRUDTarea crudTarea;
     private String auxiliar,auxiliar2;
    private ArrayList<String[]> dato;
    public TareasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TareasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TareasFragment newInstance(String param1, String param2) {
        TareasFragment fragment = new TareasFragment();
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

        View vista=inflater.inflate(R.layout.fragment_tareas, container, false);
        crudTarea=new CRUDTarea(getContext());
        listView=(ListView) vista.findViewById(R.id.listaTareas);
        listView.setOnItemLongClickListener(this);
        dato=new ArrayList<>();
        adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_selectable_list_item);
        Bundle bundle=getArguments();
        int dia,mes,anio;
        dia=mes=anio=0;
        auxiliar="";
        auxiliar2="";
        fecha =(Fecha) bundle.getSerializable("date");

        dato = crudTarea.Cargar(fecha, adapter, listView, getContext());

        // Inflate the layout for this fragment
        return vista;
    }



    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        CharSequence []items=new CharSequence[2];
        items[0]="Eliminar Tarea";
        items[1]="Cancelar";
        builder.setTitle("Eliminar Tarea").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(which==0){

                   dato= crudTarea.borrarTareas(getContext(),adapter,dato,parent.getItemAtPosition(position).toString(),listView,fecha,position);
                  //  dato = crudTarea.Cargar(fecha, adapter, listView, getContext());
                }

            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();

        return false;
    }



}
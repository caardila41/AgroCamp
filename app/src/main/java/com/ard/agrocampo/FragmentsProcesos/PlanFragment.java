package com.ard.agrocampo.FragmentsProcesos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ard.agrocampo.Clases.Cultivos;
import com.ard.agrocampo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlanFragment extends Fragment implements CalendarView.OnDateChangeListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView planta,proyecto,tipoCultivo;
    ImageView fotoPlanta;



    private CalendarView calendar;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public PlanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlanFragment newInstance(String param1, String param2) {
        PlanFragment fragment = new PlanFragment();
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


        View vista=inflater.inflate(R.layout.fragment_plan, container, false);

        planta=(TextView) vista.findViewById(R.id.nombrePlanta);
        proyecto=(TextView) vista.findViewById(R.id.nombreProyecto);
        tipoCultivo=(TextView) vista.findViewById(R.id.tipo);
        fotoPlanta=(ImageView) vista.findViewById(R.id.imagenReferencia);
        calendar=(CalendarView)vista.findViewById(R.id.calendario);
        calendar.setOnDateChangeListener(this);


        Bundle bundle=getArguments();

        Cultivos Cultivo_Plan=null;

    if (bundle!=null){
        Cultivo_Plan=(Cultivos) bundle.getSerializable("objeto");

        planta.setText(Cultivo_Plan.getNombre());
        proyecto.setText(Cultivo_Plan.getProyectoNombre());
        tipoCultivo.setText(Cultivo_Plan.getTipo());
        fotoPlanta.setImageResource(Cultivo_Plan.getFoto());

    }

        // Inflate the layout for this fragment
        return vista;
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        CharSequence []items=new CharSequence[3];
        items[0]="Ver Tareas";
        items[1]="Agregar Tarea";
        items[2]="Cancelar";
        builder.setTitle("Seleciona un tarea").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (which==0){

                }else if (which==1){

                }else {
                    return;
                }
            }
        });
AlertDialog dialog=builder.create();
dialog.show();
    }
}
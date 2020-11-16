package com.ard.agrocampo.FragmentsProcesos;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ard.agrocampo.CRUD.CRUDCereales;
import com.ard.agrocampo.Clases.Cultivos;
import com.ard.agrocampo.Clases.Fecha;
import com.ard.agrocampo.Clases.Proceso;
import com.ard.agrocampo.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCereales#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCereales extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


private  TextView descrip,nombre;
private ImageView imagen;
private EditText fechaini,areacultivo,nombrecultivo;



private  int Foto;
private  double areaC;
private  String name,tipo,descripcion,nombreC;

private Button btnCrear;

private  int anno, mes , dia;
private  Fecha fecha;

CRUDCereales crudCereales;

    public FragmentCereales() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCereales.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCereales newInstance(String param1, String param2) {
        FragmentCereales fragment = new FragmentCereales();
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

        crudCereales=new CRUDCereales(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View vista= inflater.inflate(R.layout.fragment_cereales, container, false);
        Bundle bundle=getArguments();
        Proceso proceso=null;
        descrip=vista.findViewById(R.id.descripcion);
        imagen=vista.findViewById(R.id.imagneCereal);
        nombre=vista.findViewById(R.id.txnombre);
        fechaini=vista.findViewById(R.id.fechainico);
        areacultivo=vista.findViewById(R.id.area);
        nombrecultivo=vista.findViewById(R.id.tcnombrecultivo);
        btnCrear=vista.findViewById(R.id.btnproject);






fechaini.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        fechaini.setInputType(InputType.TYPE_NULL);
        Calendar C=Calendar.getInstance();
        dia=C.get(Calendar.DAY_OF_MONTH);
        mes=C.get(Calendar.MONTH);
        anno=C.get(Calendar.YEAR);
        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                String fecha = String.valueOf(year) +"-"+String.valueOf(monthOfYear)
                        +"-"+String.valueOf(dayOfMonth);
                fechaini.setText(fecha);

            }
        }, anno, mes, dia);

        datePicker.show();



    }
});



        if (bundle!=null){
            proceso= (Proceso) bundle.getSerializable("objeto");
            descrip.setText(proceso.getDescripcion());
            imagen.setImageResource(proceso.getFoto());
            nombre.setText(proceso.getNombre());
            Foto=proceso.getFoto();



        }

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fecha= new Fecha(dia,mes,anno);

                areaC=Double.parseDouble(areacultivo.getText().toString());
                nombreC=nombrecultivo.getText().toString();
                descripcion=descrip.getText().toString();
                name=nombre.getText().toString();



                tipo="cereal";
                Cultivos cultivo=new Cultivos(name,descripcion,tipo,Foto,areaC,fecha,nombreC);

                crudCereales.Registrar(cultivo,getActivity());

            }
        });



        // Inflate the layout for this fragment
        return  vista;






    }








}


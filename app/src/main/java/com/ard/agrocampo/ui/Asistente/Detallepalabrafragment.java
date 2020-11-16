package com.ard.agrocampo.ui.Asistente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ard.agrocampo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detallepalabrafragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detallepalabrafragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView textotitulo;
    ImageView imagendetalle;
    TextView textodesc;
    TextView textoNutri;
    TextView textoprocedimiento;
    TextView Fuente;


    public Detallepalabrafragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Detallepalabrafragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Detallepalabrafragment newInstance(String param1, String param2) {
        Detallepalabrafragment fragment = new Detallepalabrafragment();
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
        View root=inflater.inflate(R.layout.fragment_detallepalabrafragment, container, false);

        textotitulo=(TextView) root.findViewById(R.id.id_titulo);
        imagendetalle=(ImageView) root.findViewById(R.id.id_imagen);
        textodesc=(TextView) root.findViewById(R.id.id_desc);
        textoNutri=(TextView) root.findViewById(R.id.id_nutri);
        textoprocedimiento=(TextView) root.findViewById(R.id.id_proceso);
        Fuente=(TextView) root.findViewById(R.id.id_fuente);

        Bundle objetoPalabra=getArguments();
        Words words=null;

        //Validación
        if (getArguments() != null) {
            words=(Words) objetoPalabra.getSerializable("objeto");
            textotitulo.setText(words.getTitulo());
            imagendetalle.setImageResource(words.getImagendetalle());
            textodesc.setText(words.getDescripcion());
            textoNutri.setText(words.getNutrientes());
            textoprocedimiento.setText(words.getProcesamiento());
            Fuente.setText(words.getFuente());
        }

        return root;
    }
}
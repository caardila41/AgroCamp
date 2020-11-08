package com.ard.agrocampo.FragmentsProcesos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ard.agrocampo.IComunicacionFragment;
import com.ard.agrocampo.Proceso;
import com.ard.agrocampo.R;
import com.ard.agrocampo.RecyclerAdapater;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSelecionProyectos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSelecionProyectos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerproductos;

    ArrayList<Proceso>  procesos;

    IComunicacionFragment interfacecom;
    Activity activity;
    public FragmentSelecionProyectos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSelecionProyectos.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSelecionProyectos newInstance(String param1, String param2) {
        FragmentSelecionProyectos fragment = new FragmentSelecionProyectos();
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

        View vista=inflater.inflate(R.layout.fragment_selecion_proyectos, container, false);

        procesos=new ArrayList<>();


        recyclerproductos=vista.findViewById(R.id.lista);

        recyclerproductos.setLayoutManager(new LinearLayoutManager(getContext()));


        llnearlista();

        RecyclerAdapater adapater=new RecyclerAdapater(procesos);
        adapater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"birnd",Toast.LENGTH_SHORT).show();

                interfacecom.enviarProducto(procesos.get(recyclerproductos.getChildAdapterPosition(v)));

            }
        });
        recyclerproductos.setAdapter(adapater);




        return vista;
    }

    private void llnearlista() {

        procesos.add(new Proceso("trigo","Trigo (Triticum spp) es el término que designa al conjunto de cereales, tanto cultivados como silvestres, que pertenecen al género Triticum; se trata de plantas anuales de la familia de las gramíneas, ampliamente cultivadas en todo el mundo. La palabra trigo designa tanto a la planta como a sus semillas comestibles, tal como ocurre con los nombres de otros cereales.\n" +
                "\n" +
                "El trigo es uno de los tres granos más ampliamente producidos globalmente, junto al maíz y el arroz.","Cereal",R.drawable.trigo));
        procesos.add(new Proceso("Maiz","Zea mays, el maíz, es una gramínea anual originaria y domesticada por pueblos indígenas en Centroamérica desde hace unos diez mil años, e introducida en Europa en el siglo XVII. Actualmente, es el cereal con el mayor volumen de producción a nivel mundial, seguido por el trigo y el arroz","Cereal",R.drawable.maiz));
        procesos.add(new Proceso("Cebada","Hordeum vulgare, la cebada, es una planta monocotiledónea anual perteneciente a la familia de las poáceas (gramíneas); a su vez, es un cereal de gran importancia tanto para animales como para humanos y es el quinto cereal más cultivado en el mundo (53 millones de hectáreas o 132 millones de acres).","Cereal",R.drawable.cebada));



    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            this.activity=(Activity) context;
            interfacecom=(IComunicacionFragment) this.activity;
        }



    }
}
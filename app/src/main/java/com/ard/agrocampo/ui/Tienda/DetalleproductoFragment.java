package com.ard.agrocampo.ui.Tienda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ard.agrocampo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleproductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleproductoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Catalogo catalogo;

    TextView textonombrepro;
    ImageView imagenproductodetalle;
    TextView textodescproducto;
    TextView textoprecio;
    Button btncomprar;


    public DetalleproductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleproductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleproductoFragment newInstance(String param1, String param2) {
        DetalleproductoFragment fragment = new DetalleproductoFragment();
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
         View root =inflater.inflate(R.layout.fragment_detalleproducto, container, false);

         imagenproductodetalle=(ImageView) root.findViewById(R.id.id_detalleproducto);
         textonombrepro=(TextView) root.findViewById(R.id.id_npro);
         textodescproducto=(TextView) root.findViewById(R.id.id_descproducto);
         textoprecio=(TextView) root.findViewById(R.id.id_precio);
         btncomprar=(Button) root.findViewById(R.id.btnpagar);


        Bundle objetoproducto =getArguments();
        catalogo=null;

        catalogo =(Catalogo) objetoproducto.getSerializable("objeto");
        textonombrepro.setText(catalogo.getNombreproducto());
        imagenproductodetalle.setImageResource(catalogo.getFotoproducto());
        textodescproducto.setText(catalogo.getDescripcionproducto());
        textoprecio.setText(catalogo.getPrecio());

        btncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleEnvio = new Bundle();
                bundleEnvio.putString("objeto",catalogo.getURL());

                Navigation.findNavController(v).navigate(R.id.detallepagoFragment,bundleEnvio);
            }
        });


        return root;
    }
}
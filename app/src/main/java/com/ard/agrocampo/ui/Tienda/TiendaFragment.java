package com.ard.agrocampo.ui.Tienda;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ard.agrocampo.R;
import com.ard.agrocampo.ui.Asistente.WordsAdapter;

import java.util.ArrayList;

public class TiendaFragment extends Fragment implements SearchView.OnQueryTextListener{

    private TiendaViewModel mViewModel;
    ArrayList<Catalogo> listaproductos;
    private ProductosAdapter productosAdapter;
    RecyclerView recyclerT;
    private SearchView Searchpro;


    public static TiendaFragment newInstance() {
        return new TiendaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

         View root =inflater.inflate(R.layout.tienda_fragment, container, false);
         recyclerT=(RecyclerView) root.findViewById(R.id.recyclerTienda);
         recyclerT.setLayoutManager(new LinearLayoutManager(getContext()));

        Searchpro= (SearchView) root.findViewById(R.id.Searchproducto);
        initListenerproductos();


        //Se llena la lista
        listaproductos=new ArrayList<>();

        listaproductos.add(new Catalogo("Fertilizante","73800","Productos","Abono Organico Mineral - Kit Full Reforzado En Nitrógeno, Fósforo, Potasio y más.\n" +
                "\n" + "El Kit cuenta con 1 Litros de FulVat Advance, 1 Litros de FulVat Plus y 1 litros de Nitrol" ,5,R.drawable.fertilizante,"https://mpago.li/2Lp2Sbw") );
        listaproductos.add(new Catalogo("Cinta Riego","26800","Productos","Cinta de riego por goteo con goteros incorporados cada 10 cms en calibre 6000, cada gotero emite 0.9 Lph y se pone en marcha con 10 PSI, ideal para cultivos con distancias de siembra muy corta y también cubrir perímetros en jardines",5,R.drawable.cintariego,"") );
        listaproductos.add(new Catalogo("Semilla maíz","23000","Semillas","Maíz de grano duro y con variedad de coloración en sus granos, dentro de una misma mazorca pueden generarse coloraciones diferentes entre amarillo, blanco y rojo, su adaptabilidad está dada entre los 1.200 a 2.000 m.s.n.m. Su ciclo productivo puede alcanzar los 6 meses.", 5,R.drawable.semillamaiz,"") );
        listaproductos.add(new Catalogo("Semilla Trigo","12000","Semillas","Es una planta herbácea. El tallo o caña es verde, rígido, formado por nudos y entrenudos. Las hojas son envaínadoras que nacen de los nudos, acintadas, sin peciolo, que poseen la vaina, parte que sobresale del tallo" ,5,R.drawable.semillatrigo,"") );


        //Especificar un adaptador donde se presentara como va a lucir la lista
        productosAdapter = new ProductosAdapter(listaproductos);
        recyclerT.setAdapter(productosAdapter);

        productosAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selección:"+listaproductos.get(recyclerT.getChildAdapterPosition(v)).getNombreproducto(),Toast.LENGTH_SHORT).show();
                Bundle bundleEnvio = new Bundle();
                bundleEnvio.putSerializable("objeto",listaproductos.get(recyclerT.getChildAdapterPosition(v)));

                Navigation.findNavController(v).navigate(R.id.detalleproductoFragment,bundleEnvio);
            }
        });

        return root;
    }

    private void initListenerproductos() {
        Searchpro.setOnQueryTextListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TiendaViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        productosAdapter.filterproductos(newText);
        return false;
    }
}
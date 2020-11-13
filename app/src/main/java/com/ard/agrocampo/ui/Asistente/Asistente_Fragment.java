package com.ard.agrocampo.ui.Asistente;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ard.agrocampo.R;

import java.util.ArrayList;

public class Asistente_Fragment extends Fragment implements SearchView.OnQueryTextListener {

    private AsistenteViewModel mViewModel;
    private RecyclerView recyclerView;
    private SearchView Search;
    private WordsAdapter wordsAdapter;
    ArrayList<Words> myDataset;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;


    public static Asistente_Fragment newInstance() {
        return new Asistente_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.asistente__fragment, container, false);

        recyclerView=(RecyclerView) root.findViewById(R.id.reyclerview);
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Search= (SearchView) root.findViewById(R.id.Search);
        initListener();


        //Se llena la lista
        myDataset=new ArrayList<>();

        myDataset.add(new Words(getString(R.string.cereal_nombre),"1",R.drawable.cereal,"CEREAL"," Los cereales forman una parte importante de la dieta de muchas personas. Incluyen el maíz, sorgo, mijo, trigo, arroz, cebada, avena, teff y quinoa. Un nuevo cereal de considerable interés es el tritical, un cruce entre el trigo y el centeno.\n" +
                "\n" +
                "Aunque la forma y el tamaño de las semillas pueden ser diferentes, todos los granos de cereales tienen una estructura y valor nutritivo similar; 100 g de grano entero suministran aproximadamente 350 kcal, de 8 a 12 g de proteína y cantidades útiles de calcio, hierro (sin embargo el ácido fítico puede dificultar su absorción) y las vitaminas B (véase el Cuadro 33). En su estado seco, los granos de cereales carecen completamente de vitamina C y excepto en el caso del maíz amarillo, no contienen caroteno (provitamina A). Para obtener una dieta balanceada, los cereales deben suplementarse con alimentos ricos en proteína, minerales y vitaminas A y C. (La vitamina D puede obtenerse a través de la exposición de la piel a la luz solar.)",
                "http://www.fao.org/3/w0073s/w0073s0u.htm#TopOfPage","El embrión es la parte del grano que germina si se planta el grano o si se lo sumerge en agua. Es muy rico en nutrientes. Aunque pequeño en tamaño, el embrión generalmente contiene 50 por ciento de la tiamina, 30 por ciento de la riboflavina y 30 por ciento de la niacina del grano entero. La aleurona y otras capas externas contienen 50 por ciento de la niacina y 35 por ciento de la riboflavina. El endospermo, aunque en general es la parte más grande del grano, generalmente contiene una tercera parte o menos de las vitaminas B. Comparado con otras partes, es más pobre en proteínas y minerales, pero es la fuente principal de energía, en la forma de un carbohidrato complejo, el almidón.",
                "Los métodos tradicionales de procesamiento, involucran el uso de una maja y mortero o piedras, las que generalmente producen un grano de cereal que ha perdido algunas de sus capas externas pero retiene por lo menos una parte del germen, incluyendo el cotiledón. Aunque con procesos muy prolongados y cuidadosos, utilizando los métodos tradicionales se puede obtener un producto altamente refinado, tal preparación es poco común. La molienda ligera, similar a moler en el hogar, también produce un producto que retiene la mayoría de los nutrientes. La mecanización de este tipo tiene la ventaja adicional de quitar una enorme carga al ama de casa, ya que la mujer generalmente es la responsable de moler el grano."));
        myDataset.add(new Words("Maíz","2",R.drawable.maiz,"MAÍZ","El maíz (Zea mays) es un alimento muy importante en toda América y gran parte de África. Se cultivó por primera vez en el continente americano y fue un alimento importante entre las grandes civilizaciones azteca y maya, mucho antes de la llegada de Colón y los colonizadores. Las semillas fueron llevadas a Europa y más tarde a África, donde el maíz es ahora la principal fuente de la dieta en muchas áreas",
                "http://www.fao.org/3/w0073s/w0073s0u.htm#TopOfPage"," Los granos de maíz contienen aproximadamente la misma cantidad de proteína que otros cereales (de 8 a 10 por ciento), pero gran parte está en forma de zeína, que es una proteína de poca calidad que contiene solamente pequeñas cantidades de lisina y triptófano. La relación evidente entre el consumo de maíz y la pelagra (véase el Capítulo 17) se debe en parte a una carencia de aminoácidos. Los granos de maíz enteros contienen 2 mg de niacina por 100 g, lo que es menor que el contenido en el trigo o en el arroz y aproximadamente el mismo contenido que en la avena. La niacina del maíz está en forma ligada y no es disponible para los humanos. En México y en otros países, el maíz es tratado con una solución alcalina de cal, la que libera la niacina y ayuda a prevenir la pelagra; el maíz tratado con cal se usa para la producción de tortillas, un alimento importante en México y América Central.\n" +
                "\n" +
                "Actualmente se están desarrollando nuevas variedades de maíz, con un mejor patrón de aminoácidos, tal es el caso del maíz opaco-2.",
                " La molienda reduce el valor nutritivo del maíz, tal como ocurre con otros cereales. La mayor popularidad y el uso de harina de maíz altamente refinada en oposición a la harina de maíz molida tradicionalmente o maíz ligeramente refinado en África, podría crear un problema, ya que el producto altamente refinado es deficiente en vitaminas B (véase el Cuadro 34); es necesario consumir 600 g de maíz altamente refinado para poder obtener la cantidad de tiamina presente en 100 g de maíz ligeramente refinado. Los constituyentes de vitamina B que se pierden en la molienda se pueden restituir en la harina de maíz, como es el caso en otras harinas de cereales, por medio de la fortificación. El enriquecimiento de este tipo ha tenido un buen efecto en muchos países. La legislación para garantizar un adecuado nivel de vitaminas B en las harinas de cereales puede ser factible y vale la pena que se adopte en otros países."));
        myDataset.add(new Words("Arroz","3",R.drawable.arroz,"ARROZ","El arroz, como otros cereales, es una hierba domesticada ; las variedades silvestres de arroz han existido durante siglos en Asia (Oryza sativa) y África (Oryza glaberina). El arroz es un alimento particularmente importante para gran parte de la población de China y muchos otros países de Asia, donde habita casi la mitad de la población mundial.","http://www.fao.org/3/w0073s/w0073s0u.htm#TopOfPage",
                "Las capas externas y el germen contienen conjuntamente casi un 80 por ciento de la tiamina en el grano de arroz. El endospermo, aunque constituye el 90 por ciento del peso del grano, contiene menos del 10 por ciento de tiamina. La lisina y la treonina son los aminoácidos limitantes en el arroz.",
                "Después de la cosecha, las semillas o granos de arroz se someten a diferentes métodos de molienda. El método tradicional hogareño para moler el arroz en un mortero de madera y aventamiento en una batea poco profunda, generalmente genera una pérdida de aproximadamente la mitad de las capas externas y el germen, dejando un producto que contiene alrededor de 0,25 mg de tiamina por 100 g. El procedimiento de molienda y subsiguiente pulido del arroz, que produce el arroz blanco altamente estimado para la venta en muchos lugares, retira casi la totalidad de las capas externas y el germen y deja un producto que sólo contiene más o menos 0,06 mg de tiamina por 100 g, una cantidad muy deficiente."));
        myDataset.add(new Words("Trigo","4",R.drawable.trigo,"TRIGO","El trigo (género Triticum) es el cereal más extensamente cultivado en el mundo y sus productos son muy importantes en la nutrición humana. En muchas partes donde no se puede cultivar el trigo, éste se importa y se está convirtiendo cada vez más en una parte importante de la dieta, especialmente para la población urbana. Sin embargo, la importación de trigo, como sucede con otros productos, debe compensarse con adecuadas exportaciones, para evitar que se drenen las divisas comerciales de un país.",
                "http://www.fao.org/3/w0073s/w0073s0u.htm#TopOfPage","El trigo suministra un poco más de proteína que el arroz y el maíz, aproximadamente 11 g por cada 100 g. El aminoácido limitante es la lisina. En muchos países industrializados la harina de trigo se fortifica con vitaminas B y algunas veces con hierro y otros nutrientes.",
                "El trigo generalmente se muele y se convierte en harina. Como ocurre con otros cereales molidos, el contenido de nutrientes depende del grado de molienda, es decir, la tasa de extracción. Las harinas de baja extracción han perdido gran parte de sus nutrientes. En algunos países en desarrollo, donde cada vez más se está utilizando el trigo, los panaderos han promovido la tendencia a utilizar más productos altamente refinados, debido a que la harina de trigo blanca tiene mejores cualidades para el horneado. Los comerciantes también prefieren el producto altamente refinado debido a que se almacena mejor. Su bajo contenido de grasa reduce las posibilidades de que se vuelva rancio, y su bajo contenido vitamínico hace que sea menos atractivo para los insectos y otras plagas."));
        myDataset.add(new Words("Mijo Y Sorgo","5",R.drawable.mijo,"MIJO Y SORGO","El mijo y el sorgo son cereales de grano extensamente cultivados en África y algunos países de Asia y América Latina. Aunque menos cultivados que el maíz, el arroz y el trigo, son alimentos importantes. Sobreviven en condiciones de sequía mejor que el maíz y otros cereales, por lo tanto se cultivan por lo común en áreas donde la lluvia es escasa e impredecible.",
                "http://www.fao.org/3/w0073s/w0073s0u.htm#TopOfPage","Existen muchas variedades de sorgo; la mayoría crecen bastante y tienen una gran inflorescencia, pero también existen variedades enanas. El grano generalmente es grande pero varía en color y formas de acuerdo al tipo. El sorgo requiere mayor humedad que el mijo pero menos que el maíz. El sorgo es un alimento nutritivo y muchas variedades tienen un mayor contenido de proteína que otros cereales.",
                "Debido a que existe la tendencia a molerlos en casa y no en el molino, están con frecuencia menos sometidos a pérdida de vitaminas, minerales y proteína. Sin embargo, en muchas áreas de África se están reemplazando por arroz y maíz, aunque generalmente continúan cultivándose para la fabricación de cerveza. En algunas partes de Asia el mijo se considera como alimento de clase baja para la gente pobre."));
        myDataset.add(new Words("Almidones Y Raices Feculentas ","6",R.drawable.almidon,"ALMIDONES","El almidón, o fécula, es una macromolécula que está compuesta por dos polímeros distintos de glucosa, la amilosa (en proporción del 25 %) y la amilopectina (75 %).Es el glúcido de reserva de la mayoría de los vegetales.","http://www.fao.org/3/w0073s/w0073s0u.htm#TopOfPage",
                "Como alimentos básicos, sin embargo, son inferiores a los cereales debido a que están compuestos de dos terceras partes de agua y tienen mucho menos proteína, al igual que cuentan con menor contenido de minerales y vitaminas. Generalmente contienen menos del 2 por ciento de proteína, mientras que los cereales contienen aproximadamente un 10 por ciento. Sin embargo, el taro y las batatas, contienen hasta un 6 por ciento de proteína de buena calidad.",
                "ara la extracción de los almidones se utilizaron rizomas frescos de makal (Xanthosoma yucatanensis), camote (Ipomea batata), yuca (Manihot esculenta Crantz) y sagú (Marantha arundinacea), los cuales fueron pelados y cortados en cubos de aproximadamente 3 cm por cada lado y fueron remojados durante 30 minutos en una solución de bisulfito de sodio con una concentración de 1500 ppm, en una relación 1:3 (p/v). Los cubos se molieron en un procesador de alimentos (Moulinex), durante 2 minutos, para reducir el tamaño de partícula. "));
        myDataset.add(new Words("Legumbres","7",R.drawable.legumbres,"LEGUMBRES","Los fríjoles, arvejas, lentejas, maní y similares pertenecen a la familia botánica de las leguminosas. Sus semillas comestibles se denominan legumbres. Agrícolamente, las plantas de este grupo tienen la ventaja de poder captar nitrógeno del aire y además agregar algo de éste a la tierra, a diferencia de la mayoría de las otras plantas que toman el nitrógeno del suelo y no lo reemplazan. Las legumbres por lo regular se desarrollan mejor cuando pueden obtener agua al iniciar su crecimiento y luego contar con un período seco y cálido para la maduración. Por lo tanto, lo usual es sembrarlas al final de la época de lluvias para que maduren al principio de la estación seca.","http://www.fao.org/3/w0073s/w0073s0u.htm#TopOfPage",
                "Las legumbres son muy importantes desde el punto de vista nutricional debido a que son un alimento vegetal ampliamente disponible, que contiene además de carbohidratos una buena cantidad de proteína y vitaminas B. Algunas legumbres, como el maní y la soja, además son ricas en aceite. Generalmente suplementan muy bien las dietas basadas en cereales en que predominan los carbohidratos. Casi todas las legumbres contienen más proteínas que la carne, pero la proteína es de calidad un poco inferior debido a que tiene menos metionina. ",
                "A menos que exista una buena razón para introducir un nuevo cultivo, como la soja, tiene más sentido promover la mayor producción y consumo de una legumbre que ya se cultive y sea popular en el área. La población local tendrá preferencia por este alimento y las condiciones agrícolas usualmente son apropiadas. Además, es muy importante tratar de introducir frijoles (y otras semillas comestibles) en la alimentación de los niños a edad temprana, pues están tan capacitados como los adultos para digerirlos con facilidad"));

        //Especificar un adaptador donde se presentara como va a lucir la lista
        wordsAdapter = new WordsAdapter(myDataset);
        recyclerView.setAdapter(wordsAdapter);

        wordsAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selección:"+myDataset.get(recyclerView.getChildAdapterPosition(v)).getPalabra(),Toast.LENGTH_SHORT).show();

                //Interfaz como puente
                interfaceComunicaFragments.enviardatos(myDataset.get(recyclerView.getChildAdapterPosition(v)));


            }

        });


        return root;
    }

    public void initListener(){
        Search.setOnQueryTextListener(this);  }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AsistenteViewModel.class);
        // TODO: Use the ViewModel
    }

    //Se ejecutara cuando se seleccione enter
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    //Detecta la letra en el searchView
    @Override
    public boolean onQueryTextChange(String newText) {
        wordsAdapter.filter(newText);
        return false;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //Establecer comunicacion entre la lista y el detalle
        if (context instanceof  Activity){
            this.activity=(Activity) context;
            interfaceComunicaFragments=(IComunicaFragments) this.activity;
        }
    }

}
package com.ard.agrocampo.Reciclaje;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import com.ard.agrocampo.R;

import java.text.Normalizer;
import java.util.ArrayList;

public class AsistenteVirtual extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private static final int RECONOCEDOR_VOZ = 7;
    private TextView escuchando;
    private TextView responder;
    private ArrayList<Respuesta> respuestas;
    private TextToSpeech leerV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistente_virtual);
        escuchando=(TextView) findViewById(R.id.tvEscuhado);
        responder=(TextView) findViewById(R.id.TvRespondiendo);
        respuestas=proveerDatos();
        leerV=new TextToSpeech(this,this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Evaluar si el resultado es el correcto

        if(resultCode==RESULT_OK && requestCode==RECONOCEDOR_VOZ){
            ArrayList<String> reconocido= data.getStringArrayListExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL);//Almacenando el dato
            String escuchado=reconocido.get(0);
            escuchando.setText(escuchado);
            prepararRespuesta(escuchado);
        }
    }

    public void Hablar (View view ){
        Intent hablar =new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        hablar.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"es-MX");
        startActivityForResult(hablar,RECONOCEDOR_VOZ);
    }

    public void prepararRespuesta (String escuchado){
        //Normalizar texto
        String normalizar= Normalizer.normalize(escuchado,Normalizer.Form.NFD);
        String sintilde = normalizar.replaceAll("[^\\p{ASCII}]","");

        int res;
        String responder = respuestas.get(0).getRespuesta();

        //Recorrer array
        for (int i=0;i<respuestas.size();i++){
            //Buscar posicion
            res=sintilde.toLowerCase().indexOf(respuestas.get(1).getCuestion());

            if(res!=1){
                responder= respuestas.get(i).getRespuesta();

            }
        }
        Responder(responder);

    }

    private void Responder(String respuestita) {
        responder.setText(respuestita);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            leerV.speak(respuestita,TextToSpeech.QUEUE_FLUSH,null,null);
        }else{
            leerV.speak(respuestita,TextToSpeech.QUEUE_FLUSH,null);
        }


    }

    public ArrayList<Respuesta> proveerDatos(){
        ArrayList<Respuesta> respuesta = new ArrayList<>();
        respuesta.add(new Respuesta ("defecto","Aun no estoy programada para responder eso"));
        respuesta.add(new Respuesta ("hola","Hola, ¿Que tal?"));
        respuesta.add(new Respuesta ("informacion","Necesitas información acerca de un producto"));
        respuesta.add(new Respuesta ("como estas","Bien, ¿En que te puedo colaborar?"));
        return respuesta;
    }


    @Override
    public void onInit(int i) {

    }
}
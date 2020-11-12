package com.ard.agrocampo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ard.agrocampo.ui.Asistente.Asistente_Fragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity  {

    private FirebaseAuth mAuth;
    private EditText email,password;
    SignInButton sinin;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.EDTemail);
        password=(EditText)findViewById(R.id.EDTpass);
        sinin=findViewById(R.id.sign_in_button);

        //BOTON DE INCIO DE SESION DE GOOGLE CLICK
        sinin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.sign_in_button:

                        //INICIO DE SESION
                        signIn();
                        break;
                    // ...
                }
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
            ///DATOS DE  USUARIO GUARDADOS ENE STA INSTACNIA
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
//FUNCIONDE INICIO DE SESIOON
    private void signIn() {
        Toast.makeText(getApplicationContext(),"Inicio de sesión Exitoso",Toast.LENGTH_SHORT).show();
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override


    ///DONDE SE PROGRMA LÓGICA PARA SABER SI EL USUARIO YA ESTA LOGUEADO EN EL CASO
    //DE LAS DOS FORMAS DE LOGUEO
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
      //  updateUI(currentUser);

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //updateUI(account);
    }

    ///ACTUALIZACIÓN DE INTERFAZ DE USUARIO
    private void updateUI(FirebaseUser currentUser) {

    }



    //INICI DE SESISION CUANDO SE USA EL CORREO CORENTRASEÑA
    public void IniciarSession(View view){
        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            Toast.makeText(getApplicationContext(),"Inicio de sesión Exitoso",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getApplicationContext(),Inicio.class);
                            startActivity(i);
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }



    //MÉTODO PARA REGISTRADSE E II A DICHA ACTIVITY
    public void Registrate (View view ){
        Intent registrate= new Intent(this,RegistrarCorreo.class);//Generar instancia entre pantallar
        //Envio de info entre pantallas
        startActivity(registrate);//Inicializar objeto
    }




///INTERFAZ DE USURUARIO DE GOOGLE SING CLIENT PARA QUE TRAIGA DICHA INFORMACIÓN DE USUARIO
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }



    ///MÉTODO PARA INICAR LA ACTIVIDAD EN CASO DE QUE PREOCEOS SEA EXITOSO PARA EL INCIO DE SESION CON GOOGLE
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
           // updateUI(account);
            Intent i=new Intent(this,Inicio.class);
            startActivity(i);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

}
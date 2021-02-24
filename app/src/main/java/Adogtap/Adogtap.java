package Adogtap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;

import Comunicacion.Comunicacion;
import Datos.Datos;
import Perfil.Perfil;
import Enlistar.Enlistar;

public class Adogtap extends AppCompatActivity {

    private TextView txt2;
    private Animal p1,p2,g1,g2;
    private Perfil perfil;
    private Datos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adogtap);
        this.setTitle(R.string.Adogtap);
        bd = new Datos();
        String idUser = getIntent().getExtras().getString("userID");
        String email = getIntent().getExtras().getString("email");
        boolean usuarioNuevo = getIntent().getExtras().getBoolean("usuarioNuevo");
        perfil = new Perfil(idUser,this, email, usuarioNuevo);



        //txt2 = (TextView)findViewById(R.id.txt2);
        //IFabricaAnimales fabrica = new FabricaAnimales();
        //p1 = fabrica.crearAnimal("Perro","Pelusa",5,"Frenchpuddle","Hembra");
        //p2 = p1.realizarClonacion();

    }

    public void enlistar(View view){
        Intent i = new Intent(this, Enlistar.class);
        startActivity(i);
    }

    public void comunidad(View view){
        Intent i = new Intent(this, Comunicacion.class);
        startActivity(i);
    }

    public void perfi(View view){
        Toast.makeText(this, "Funcionalidad aún en progreso", Toast.LENGTH_LONG).show();
    }

    public void cerrar(View view){
        finish();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Datos getBd() {
        return bd;
    }


}

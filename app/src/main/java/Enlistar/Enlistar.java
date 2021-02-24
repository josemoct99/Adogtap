package Enlistar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.login.R;

import java.util.ArrayList;

import Adogtap.Animal;
import Adogtap.Gato;
import Adogtap.Perro;

public class Enlistar extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        this.setTitle(R.string.Seleccion);

        lvItems = findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, getArrayItems());
        lvItems.setAdapter(adaptador);

    }

    private ArrayList<Animal> getArrayItems(){
        ArrayList<Animal> lista = new ArrayList<>();
        lista.add(new Perro("Pelusa",5,"Pastor Aleman","Hembra", R.drawable.dbs_1));
        lista.add(new Perro("Pucca",5,"Bulldog","Hembra", R.drawable.dbs_2));
        lista.add(new Perro("Pepe",5,"Poodle","Hembra", R.drawable.dbs_3));
        lista.add(new Gato("Luna",5,"Siames","Macho", R.drawable.dbs_4));
        lista.add(new Gato("Finn",5,"Persa","Hembra", R.drawable.dbs_5));
        lista.add(new Perro("Ninguno",5,"Labrador","Hembra", R.drawable.dbs_6));
        lista.add(new Perro("Finn",5,"Chihuahua","Hembra", R.drawable.dbs_7));
        lista.add(new Perro("Finn",5,"Bulldog","Hembra", R.drawable.dbs_8));
        lista.add(new Perro("Finn",5,"Rottweiler","Hembra", R.drawable.dbs_9));
        lista.add(new Gato("Finn",5,"Bengala","Hembra", R.drawable.dbs_10));
        lista.add(new Gato("Finn",5,"Ragdoll","Hembra", R.drawable.dbs_11));

        return lista;
    }

    public void volver(View view){
        finish();
    }
}
package Datos;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.login.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import Adogtap.Adogtap;
import Adogtap.Animal;
import Interfaces.IBDAnimal;
import Interfaces.IBDUsuario;
import Perfil.Perfil;

public class Datos implements IBDUsuario, IBDAnimal{

    DatabaseReference bdPrincipal;

    public Datos() {
        bdPrincipal = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void insertarAnimal(Animal animal) {

    }


    @Override
    public void obtenerListaAnimales(String tipoAnimal) {

    }

    @Override
    public void obtenerAnimal(String idAnimal) {

    }

    @Override
    public void insertarUsuario(Perfil usuario) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nombre", usuario.getNombre());
        map.put("edad", usuario.getEdad());
        map.put("direccion", usuario.getDirección());
        map.put("email", usuario.getEmail());
        bdPrincipal.child("Usuarios").child(usuario.getId()).setValue(map);
    }

    @Override
    public void obtenerListaUsuarios() {

    }

    @Override
    public void obtenerUsuario(String id) {

    }
}

package Perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.login.MainActivity;
import com.example.login.R;

import Adogtap.Adogtap;
import Interfaces.IUsuario;

public class Perfil extends AppCompatActivity implements IUsuario{

    private String id;
    private String nombre;
    private int edad;
    private String direccion;
    private String email;
    private boolean usuarioNuevo;
    private Adogtap principal;
    public TextView txtnombre;
    public TextView txtedad;
    public TextView txtdireccion;
    public TextView txtcorreo;
    public TextView txtid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txtedad = (TextView)findViewById(R.id.txtEdad);

        txtdireccion = (TextView)findViewById(R.id.txtdireccion);
        txtcorreo = (TextView)findViewById(R.id.txtcorrreo);
        txtid = (TextView)findViewById(R.id.txtid);

        txtnombre.setText(nombre);
        txtedad.setText(edad);
        txtdireccion.setText(direccion);
        txtcorreo.setText(email);
        txtid.setText(id);
    }

    public Perfil(String id, Adogtap principal, String email, boolean usuarioNuevo) {
        this.id = id;
        this.principal = principal;
        this.email = email;
        this.usuarioNuevo = usuarioNuevo;
        actualizarDatos();
    }

    public void regresar(View view){
        finish();
    }
    @Override
    public void mostrarDatos() {

    }

    @Override
    public void editarDatos() {

    }

    @Override
    public void mostrarAdopcionesDeseadas() {

    }

    @Override
    public void mostrarAdopcionesPropuestas() {

    }

    public void actualizarDatos() {
        if(isUsuarioNuevo()){
            nombre = "Nombre Default";
            edad = 0;
            direccion = "Dirección default";
            principal.getBd().insertarUsuario(this);
            setUsuarioNuevo(false);
            //Toast.makeText(this, "SE ACTUALIZARON LOS DATOS", Toast.LENGTH_LONG).show();
        }else{
            nombre = "Nombre Default";
            edad = 0;
            direccion = "Dirección default";

            //Toast.makeText(this, "NO SE ACTUALIZARON LOS DATOS", Toast.LENGTH_LONG).show();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDirección() {
        return direccion;
    }

    public void setDireccion(String dirección) {
        this.direccion = direccion;
    }

    public Adogtap getPrincipal() {
        return principal;
    }

    public void setPrincipal(Adogtap principal) {
        this.principal = principal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(boolean usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

    public String getId() {
        return id;
    }

}
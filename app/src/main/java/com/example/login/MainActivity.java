package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import Adogtap.Adogtap;

public class MainActivity extends AppCompatActivity{

    DatabaseReference bdPrincipal;
    EditText textEmail;
    EditText textPassword;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(R.string.IniciarSesion);
        bdPrincipal = FirebaseDatabase.getInstance().getReference();

        textEmail = (EditText)findViewById(R.id.txt_usuario);
        textPassword = (EditText)findViewById(R.id.txt_password);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = firebaseAuth.getInstance();
    }

    public void metodoprueba(View view){
        Intent i = new Intent(this, Adogtap.class);
        startActivity(i);
    }

    public void registarUsuario(View view) {
        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();
        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Se ha registrado el usuario con el email: " + email, Toast.LENGTH_LONG).show();
                            String userID = firebaseAuth.getCurrentUser().getUid();
                            Intent i = new Intent(MainActivity.this, Adogtap.class);
                            i.putExtra("userID", userID);
                            i.putExtra("email", email);
                            i.putExtra("usuarioNuevo", true);
                            startActivity(i);
                        } else {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(MainActivity.this, "El usuario ya existe", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(MainActivity.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }

                        }
                        progressDialog.dismiss();
                    }
                });
        }

    public void loguearUsuario(View view){
        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();
        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Verificando información ...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            String userID = firebaseAuth.getCurrentUser().getUid();
                            Intent i = new Intent(MainActivity.this, Adogtap.class);
                            i.putExtra("userID", userID);
                            i.putExtra("email", email);
                            i.putExtra("usuarioNuevo", false);
                            startActivity(i);
                            Toast.makeText(MainActivity.this, "Bienvenido " + email, Toast.LENGTH_LONG).show();
                        } else {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(MainActivity.this, "Verifique su contraseña", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(MainActivity.this, "Error al iniciar de sesión ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }
    }
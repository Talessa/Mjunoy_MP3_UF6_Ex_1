package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.talessa.mjunoy_mp3_uf6_ex_1.model.Persona;

import io.realm.Realm;

public class AnadirActivity extends AppCompatActivity {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir);

        realm = Realm.getDefaultInstance();

        final EditText nombreEdit = findViewById(R.id.nombre);
        final EditText apellidosEdit = findViewById(R.id.apellidos);
        final EditText edadEdit = findViewById(R.id.edad);
        final EditText generoEdit = findViewById(R.id.genero);
        final EditText emailEdit = findViewById(R.id.email);


        findViewById(R.id.insertar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEdit.getText().toString().trim();
                String apellidos = apellidosEdit.getText().toString().trim();
                String edad = edadEdit.getText().toString().trim();
                String genero = generoEdit.getText().toString().trim();
                String email = emailEdit.getText().toString().trim();

                if (nombre.length() > 0
                        && apellidos.length() > 0
                        && edad.length() > 0
                        && genero.length() > 0
                        && email.length() > 0){
                       crearpersona(nombre,apellidos,edad,genero,email);
                }else {
                    Toast.makeText(AnadirActivity.this,
                            "Debe rellenar todos los campos",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void crearpersona(String nombre, String apellidos, String edad, String genero, String email) {

        int edadN = Integer.parseInt(edad);
        long id = 1+System.currentTimeMillis();

        realm.beginTransaction();
        Persona persona = new Persona();
        persona.setid(id);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setEdad(edadN);
        persona.setGenero(genero);
        persona.setEmail(email);
        realm.copyToRealm(persona);
        realm.commitTransaction();
        Toast.makeText(AnadirActivity.this,
                "Persona añadida correctamente",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AnadirActivity.this,InicioActivity.class);
        startActivity(intent);
    }
}

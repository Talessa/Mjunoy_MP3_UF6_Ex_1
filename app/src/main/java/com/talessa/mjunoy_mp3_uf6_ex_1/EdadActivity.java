package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EdadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad);

        final CheckBox mayor = findViewById(R.id.mayor);
        final CheckBox menor = findViewById(R.id.menor);
        final EditText edadI = findViewById(R.id.edad);

        findViewById(R.id.enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String edad = edadI.getText().toString().trim();
               if(edad.length() > 0) {
                   if (mayor.isChecked()) {
                       Intent intent = new Intent(EdadActivity.this,VerEdadActivity.class);
                       intent.putExtra("opcion","mayor");
                       intent.putExtra("edad",edad);
                       startActivity(intent);
                   } else if (menor.isChecked()) {
                       Intent intent = new Intent(EdadActivity.this,VerEdadActivity.class);
                       intent.putExtra("opcion","menor");
                       intent.putExtra("edad",edad);
                       startActivity(intent);
                   } else {
                       Toast.makeText(EdadActivity.this, "Debe seleccionar una opcion", Toast.LENGTH_SHORT).show();
                   }
               }else {
                   Toast.makeText(EdadActivity.this, "Debe introducir una edad", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}

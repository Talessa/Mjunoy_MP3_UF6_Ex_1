package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class GeneroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);
        final CheckBox hombre = findViewById(R.id.hombre);
        final CheckBox mujer = findViewById(R.id.mujer);

        findViewById(R.id.enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GeneroActivity.this,VerGeneroActivity.class);
                if (hombre.isActivated()){
                    intent.putExtra("opcion","hombre");
                    startActivity(intent);
                }else if (mujer.isActivated()){
                    intent.putExtra("opcion","mujer");
                    startActivity(intent);
                }else {
                    Toast.makeText(GeneroActivity.this, "Debe seleccionar una opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

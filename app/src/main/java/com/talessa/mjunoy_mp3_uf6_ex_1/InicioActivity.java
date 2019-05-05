package com.talessa.mjunoy_mp3_uf6_ex_1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        findViewById(R.id.lista).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.añadir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this,AnadirActivity.class);
                startActivity(intent);
            }
        });

    }
}

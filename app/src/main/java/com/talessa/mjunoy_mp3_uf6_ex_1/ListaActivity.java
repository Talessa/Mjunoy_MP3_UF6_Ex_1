package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import static android.os.Build.VERSION_CODES.O;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        findViewById(R.id.todo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaActivity.this, VerListaActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.rango).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaActivity.this,RangoEdadActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.edad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaActivity.this,EdadActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.genero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaActivity.this,GeneroActivity.class);
                startActivity(intent);
            }
        });


    }
}

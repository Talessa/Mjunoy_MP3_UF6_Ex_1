package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RangoEdadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rango_edad);

        final EditText num1 = findViewById(R.id.edad1);
        final EditText num2 = findViewById(R.id.edad2);

        findViewById(R.id.enviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed1 = num1.getText().toString().trim();
                String ed2 = num2.getText().toString().trim();
                if (ed1.length() > 0 && ed2.length() > 0 ){

                    Intent intent = new Intent(RangoEdadActivity.this,VerRangoActivity.class);
                    intent.putExtra("EDADA",ed1);
                    intent.putExtra("EDADB",ed2);
                    startActivity(intent);
                }else {
                    Toast.makeText(RangoEdadActivity.this,
                            "Faltan campos por rellenar",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

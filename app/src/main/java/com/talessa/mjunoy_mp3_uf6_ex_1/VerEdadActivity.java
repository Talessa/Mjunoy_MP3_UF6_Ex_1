package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.talessa.mjunoy_mp3_uf6_ex_1.model.Persona;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class VerEdadActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Persona>> {

    Realm realm;
    RealmAdapter adapter;
    ListView listView;
    RealmResults<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_edad);

        Intent intent= getIntent();

        String opcion = intent.getStringExtra("opcion");
        String edad1 = intent.getStringExtra("edad");
        int edad = Integer.parseInt(edad1);

        realm=Realm.getDefaultInstance();
        listView=findViewById(R.id.listaview);
        if (opcion.equalsIgnoreCase("mayor")){
            mostrarmayor(edad);
        }else {
            mostrarmenor(edad);
        }
    }

    private void mostrarmenor(int edad) {
        load();
        personas= personas.where()
                .lessThan("edad",edad)
                .findAll();
        adapter =  new RealmAdapter(this,personas,R.layout.item_persona);
        listView.setAdapter(adapter);
    }

    private void mostrarmayor(int edad) {
        load();
        personas= personas.where()
                .greaterThan("edad",edad)
                .findAll();
        adapter =  new RealmAdapter(this,personas,R.layout.item_persona);
        listView.setAdapter(adapter);
    }

    private void load() {
        personas = realm.where(Persona.class).findAll();
        personas.addChangeListener(this);

        adapter = new RealmAdapter(this,personas,R.layout.item_persona);

    }
    @Override
    public void onChange(RealmResults<Persona> personas) {
        adapter.notifyDataSetChanged();
    }
}

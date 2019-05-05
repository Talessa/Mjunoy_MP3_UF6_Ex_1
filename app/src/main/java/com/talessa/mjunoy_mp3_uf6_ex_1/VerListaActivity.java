package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.talessa.mjunoy_mp3_uf6_ex_1.model.Persona;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class VerListaActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Persona>> {

    Realm realm;
    RealmAdapter adapter;
    ListView listView;
    RealmResults<Persona> personas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        realm=Realm.getDefaultInstance();
        listView=findViewById(R.id.listaview);
        load();
        mostrarIndicaciones();
    }

    private void load() {
        personas = realm.where(Persona.class).findAll();
        personas.addChangeListener(this);

        adapter = new RealmAdapter(this,personas,R.layout.item_persona);
        listView.setAdapter(adapter);
    }
    private void mostrarIndicaciones() {
        Toast.makeText( VerListaActivity.this,
                "Pulse una vez para modificar y mantenga para borrar",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onChange(RealmResults<Persona> personas) {
        adapter.notifyDataSetChanged();
    }
}

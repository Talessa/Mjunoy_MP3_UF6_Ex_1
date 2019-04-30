package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.talessa.mjunoy_mp3_uf6_ex_1.model.Persona;

import io.realm.Realm;
import io.realm.RealmConfiguration;

class MyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("Mibdd.realm")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Persona persona=realm.createObject(Persona.class);
        persona.setid(0);
        persona.setNombre("persona1");
        persona.setApellidos("apellido de la persona 1");
        persona.setEdad(30);
        persona.setEmail("emailperosna1@gmail.com");
        persona.setGenero("Mujer");
        realm.commitTransaction();
    }
}

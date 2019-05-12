package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        realmconfig();
        Realm realm = Realm.getDefaultInstance();
        realm.close();
    }

    private void realmconfig() {

        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .name("Mibdd.realm")
                .schemaVersion(1)
                .migration(new RealmMigration())
                .build();
        Realm.setDefaultConfiguration(config);
    }


}

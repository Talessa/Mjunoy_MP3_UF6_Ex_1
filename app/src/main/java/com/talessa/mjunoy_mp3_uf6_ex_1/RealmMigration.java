package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class RealmMigration implements io.realm.RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();
        //primera migracion en la que añado un nuevo campo llamado direccion.
        if (oldVersion == 0){
            Log.d("Migration", "actualitzant a la versió 1");
            RealmObjectSchema personaSchema= schema.get("Persona");
            personaSchema
                    .addField("nombrecompleto", String.class, FieldAttribute.REQUIRED)
            // elemplo de como cambiar datos ya obtenidos
            .transform(new RealmObjectSchema.Function() {
                @Override
                public void apply(DynamicRealmObject obj) {
                    obj.set("nombrecompleto", obj.getString("nombre")+" "+obj.getString("apellidos"));
                }
            })
                    .removeField("nombre")
                    .removeField("apellidos");
            oldVersion++;
        }

    }
}

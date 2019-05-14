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
        //primera migracion en la que combino el campo nombre y apellidos por nombre completo
        if (oldVersion == 0) {
            Log.d("Migration", "actualitzant a la versió 1");
            RealmObjectSchema personaSchema = schema.get("Persona");
            personaSchema
                    //añado la columna nombre completo
                    .addField("nombrecompleto", String.class, FieldAttribute.REQUIRED)
                    // relleno la columna nombre completo de los usuarios existentes con la combinacion de su nombre y su apellido
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            obj.set("nombrecompleto", obj.getString("nombre") + " " + obj.getString("apellidos"));
                        }
                    })
                    //elimino las columnas nombre y apellidos de la base de datos
                    .removeField("nombre")
                    .removeField("apellidos");
            //sumo uno a la version para impedir que una vez echa la migracion esta se repita
            oldVersion++;
        }

    }
}

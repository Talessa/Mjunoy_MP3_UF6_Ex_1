package com.talessa.mjunoy_mp3_uf6_ex_1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.talessa.mjunoy_mp3_uf6_ex_1.model.Persona;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmAdapter extends BaseAdapter {

    private Context context;
    private List<Persona> personas;
    private int layout;

    public RealmAdapter(Context context, List<Persona> list, int layout) {
        this.context=context;
        this.personas=list;
        this.layout=layout;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.card = view.findViewById(R.id.cards);
            viewHolder.nombre = view.findViewById(R.id.nombre);
            viewHolder.apellidos = view.findViewById(R.id.apellidos);
            viewHolder.edad = view.findViewById(R.id.edad);
            viewHolder.genero = view.findViewById(R.id.genero);
            viewHolder.email = view.findViewById(R.id.email);
            view.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) view.getTag();
        }

//        viewHolder.nombre.setText(personas.get(position).getNombre());
//        viewHolder.apellidos.setText(personas.get(position).getApellidos());
        String ed1= String.valueOf(personas.get(position).getEdad());
        viewHolder.edad.setText(ed1);
        viewHolder.genero.setText(personas.get(position).getGenero());
        viewHolder.email.setText(personas.get(position).getEmail());

        viewHolder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                eliminar(personas.get(position));
                return false;
            }
        });

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editar(personas.get(position));
                }
        });

        return view;
    }

    private void editar(final Persona persona) {

        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        builder.setTitle("Edita la persona:");
        View viewI = LayoutInflater.from(context).inflate(R.layout.modificar_persona,null);
        builder.setView(viewI);

        final EditText nombre = viewI.findViewById(R.id.nombre);
        final EditText apellidos = viewI.findViewById(R.id.apellidos);
        final EditText edad = viewI.findViewById(R.id.edad);
        final EditText genero = viewI.findViewById(R.id.genero);
        final EditText email = viewI.findViewById(R.id.email);

//        nombre.setText(persona.getNombre());
//        apellidos.setText(persona.getApellidos());
        String ed1= String.valueOf(persona.getEdad());
        edad.setText(ed1);
        genero.setText(persona.getGenero());
        email.setText(persona.getEmail());

        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nombreM = nombre.getText().toString().trim();
                String apellidosM = apellidos.getText().toString().trim();
                String edadM = edad.getText().toString();
                String generoM = genero.getText().toString().trim();
                String emailM = email.getText().toString().trim();

                if (nombreM.length() >0
                        && apellidosM.length() > 0
                        && edadM.length() > 0
                        && generoM.length() > 0
                        && emailM.length() > 0) {
                    //
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
//                    persona.setNombre(nombreM);
//                    persona.setApellidos(apellidosM);
                    persona.setEdad(Integer.parseInt(edadM));
                    persona.setGenero(generoM);
                    persona.setEmail(emailM);
                    realm.copyToRealmOrUpdate(persona);
                    realm.commitTransaction();
                    Toast.makeText(context, "La persona se modifico correctamente", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(context, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void eliminar (final Persona persona){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Desea borrar la persona?");

        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                persona.deleteFromRealm();
                realm.commitTransaction();
            }
        });

        builder.setNegativeButton("No",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "El contacto no se eliminara", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public class ViewHolder{
        CardView card;
        TextView nombre;
        TextView apellidos;
        TextView edad;
        TextView genero;
        TextView email;
    }
}

package com.arturopacheco.miscontactos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private ContactDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton add = (FloatingActionButton)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(MainActivity.this, AgregarContactos.class);
                startActivity(add);
            }
        });


        dataSource = new ContactDataSource(this);
        dataSource.open();
        contactos = dataSource.GetContactos();

        /*new ArrayList();
        contactos.add(new Contacto("Benito","123456789","benito@email.com"));
        contactos.add(new Contacto("Mariana","123123","mariana@email.com"));
        contactos.add(new Contacto("Juan Perez","35435345","juan@email.com"));
        contactos.add(new Contacto("Luis Lopez","54645645","luis@email.com"));*/
        ArrayList<String> nombres = new ArrayList<String>();

        for (Contacto contacto:contactos ) {
            nombres.add(contacto.getNombre());

        }

        ListView listViewContactos = (ListView) findViewById(R.id.listViewContactos);
        listViewContactos.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombres));

        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetallesContacto.class);
                intent.putExtra("nombre",contactos.get(position).getNombre());
                intent.putExtra("telefono",contactos.get(position).getTelefono());
                intent.putExtra("email", contactos.get(position).getEmail());

                startActivity(intent);
            }
        });

    }
}

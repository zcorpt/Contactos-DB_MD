package com.arturopacheco.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgregarContactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos);

        Button agregar = (Button)findViewById(R.id.registrar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lista_contactos = new Intent(AgregarContactos.this, MainActivity.class);
                startActivity(lista_contactos);
            }
        });
    }
}

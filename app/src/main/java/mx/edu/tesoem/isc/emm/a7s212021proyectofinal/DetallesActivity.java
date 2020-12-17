package com.example.proyect0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetallesActivity extends AppCompatActivity {

    TextView lblnombre, lblmatricula, lblcorreo, lblpromedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        lblnombre = findViewById(R.id.dlblNombre);
        lblmatricula = findViewById(R.id.dlblMatricula);
        lblcorreo = findViewById(R.id.dlblCorreo);
        lblpromedio = findViewById(R.id.dlblPromedio);

        String nombre = getIntent().getExtras().get("Nombre").toString();
        DatosParcelable dato = getIntent().getParcelableExtra("DatosParcelable");

        lblnombre.setText(dato.getNombre());
        lblmatricula.setText(dato.getMatricula());
        lblcorreo.setText(dato.getCorreo());
        lblpromedio.setText(dato.getPromedio());

        getSupportActionBar().setTitle(nombre);


    }
}
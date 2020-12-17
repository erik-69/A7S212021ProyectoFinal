package com.example.proyect0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gvDatos;
    EditText txtnombre, txtmatricula, txtcorreo, txtpromedio;
    List<Datos> datos = new ArrayList<>();
    AdaptadorBase adaptadorBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvDatos = findViewById(R.id.gvDatos);
        txtnombre = findViewById(R.id.txtNombre);
        txtmatricula = findViewById(R.id.txtMatricula);
        txtcorreo = findViewById(R.id.txtCorreo);
        txtpromedio = findViewById(R.id.txtPromedio);

        Verifica();

        gvDatos.setOnItemClickListener((parent, view, position, id) -> {
            Datos dato = (Datos) adaptadorBase.getItem(position);
            DatosParcelable datosParcelable = new DatosParcelable(dato.getNombre(), dato.getMatricula(), dato.getCorreo(), dato.getCorreo());
            Intent intent = new Intent(MainActivity.this, DetallesActivity.class);
            intent.putExtra("Nombre", dato.getNombre());
            intent.putExtra("DatosParcerable", datosParcelable);
            startActivity(intent);
        });

    }

    private void Verifica(){
        Almacen conexion = new Almacen();

        if (conexion.Existe(this)){
            if (conexion.Leer(this)){
                datos = conexion.getDatos();
                adaptadorBase = new AdaptadorBase(datos, this);
                gvDatos.setAdapter(adaptadorBase);
            }else {
                Toast.makeText(this, "No se pudo leer la información", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "No existe archivo, favor de registrar información", Toast.LENGTH_SHORT).show();
        }

    }

    public void Graba(View v){

        Datos dato = new Datos();
        Almacen conexion = new Almacen();

        dato.setNombre(txtnombre.getText().toString());
        dato.setMatricula(txtmatricula.getText().toString());
        dato.setCorreo(txtcorreo.getText().toString());
        dato.setPromedio(txtpromedio.getText().toString());

        datos.add(dato);
        if (conexion.Escribir(this,datos)){
            Toast.makeText(this, "La información se registró correctamente", Toast.LENGTH_SHORT).show();
            Verifica();
        }else {
            Toast.makeText(this, "No se pudo registrar la información", Toast.LENGTH_SHORT).show();
        }

    }

}
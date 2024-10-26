package com.banco.appbanco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Agregar_Movimiento extends AppCompatActivity implements MoviVacio.OnRespuesta{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_movimiento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button borrar = (Button) findViewById(R.id.btnBorrarCampos);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nombre = (EditText) findViewById(R.id.etNombreMovimiento);
                EditText des = (EditText) findViewById(R.id.etDescripcion);
                EditText cantidad = (EditText) findViewById(R.id.etCantidad);

                nombre.setText("");
                des.setText("");
                cantidad.setText("");
            }
        });

        Button volverPrincipal = (Button) findViewById(R.id.btnVolver);
        volverPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Agregar_Movimiento.this, Principal.class);
                // Iniciar la actividad
                startActivity(intent);
            }
        });

        Button subir = (Button) findViewById(R.id.btnAgregarMovimiento);
        subir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });
    }

    public void guardarDatos(){
        EditText nombre = (EditText) findViewById(R.id.etNombreMovimiento);
        EditText des = (EditText) findViewById(R.id.etDescripcion);
        EditText cantidad = (EditText) findViewById(R.id.etCantidad);
        Spinner tipoMovi = (Spinner) findViewById(R.id.spTipoMovimiento);

        String no = nombre.getText().toString();
        String descripcion = des.getText().toString();
        String canti = cantidad.getText().toString();

        if(no.isEmpty() || descripcion.isEmpty() || canti.isEmpty()){
            MoviVacio dia = new MoviVacio();
            dia.show(getSupportFragmentManager(), "Esta vacio");
        }else{
            int cantid = Integer.parseInt(canti);
        }
    }

    @Override
    public void onRespuesta(String s) {
        Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
    }
}
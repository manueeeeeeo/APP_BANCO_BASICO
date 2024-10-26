package com.banco.appbanco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button iniciar = (Button) findViewById(R.id.btnIniciar);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText cla = (EditText) findViewById(R.id.txtPassword);
                int clave = Integer.parseInt(cla.getText().toString());
                if(clave==1234){
                    // Crear el intent para iniciar la SecondActivity
                    Intent intent = new Intent(MainActivity.this, Principal.class);
                    // Iniciar la actividad
                    startActivity(intent);
                }else{
                    cla.setText("");
                }
            }
        });
        TextView contra = (TextView) findViewById(R.id.txtRecoverPassword);
        contra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecuperarPass dia = new RecuperarPass();
                dia.show(getSupportFragmentManager(), "Contraseña");
            }
        });
    }
}
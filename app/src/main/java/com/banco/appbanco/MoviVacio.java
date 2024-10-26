package com.banco.appbanco;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MoviVacio extends DialogFragment {
    OnRespuesta respuesta;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Usamos la clase Builder para construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Escribimos el título
        builder.setTitle("ERROR!");
        //Escribimos la pregunta
        builder.setMessage("Existen campos vacios, asgurese de que todos los campos estén rellenos, por favor!!");
        //añadimos el botón de Si y su acción asociada
        builder.setPositiveButton("¡OKEY!", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta("Okey");
            }
        });
        // Crear el AlertDialog y devolverlo
        return builder.create();
    }
    public interface OnRespuesta {
        void onRespuesta(String s);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        respuesta=(OnRespuesta)context;
    }
}

package com.marianamontano.agendaweek2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detalle extends AppCompatActivity {
    private TextView text1,text2,text3,text4,text5;
    private Button editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);

        text1 = (TextView) findViewById(R.id.txNombre);
        text2 = (TextView) findViewById(R.id.txFecha);
        text3 = (TextView) findViewById(R.id.txTelefono);
        text4 = (TextView) findViewById(R.id.txEmail);
        text5 = (TextView) findViewById(R.id.txComentarios);
        editar = (Button) findViewById(R.id.btnEditar);

        Bundle parametros = getIntent().getExtras(); // Para enviar datos entre activies se hace uso de la clase Bundle
        String nombre = parametros.getString(getResources().getString(R.string.pnombre)); // nombre
        String fecha = parametros.getString(getResources().getString(R.string.pfecha)); // fecha nacimiento
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono)); // telefono
        String email = parametros.getString(getResources().getString(R.string.pemail));// email
        String comentario = parametros.getString(getResources().getString(R.string.comentario)); //comentarios

        text1.setText(nombre);
        text2.setText(fecha);
        text3.setText(telefono);
        text4.setText(email);
        text5.setText(comentario);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detalle.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre),text1.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha),text2.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),text3.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),text4.getText().toString());
                intent.putExtra(getResources().getString(R.string.comentario),text5.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}

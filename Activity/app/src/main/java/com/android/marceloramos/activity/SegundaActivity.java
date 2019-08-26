package com.android.marceloramos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome= findViewById(R.id.idNome);
        textIdade = findViewById(R.id.idIdade);

        //recuperar dados enviados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");

        //configurar valores recuperados
        textNome.setText(nome);
        textIdade.setText(String.valueOf(idade));

    }
}

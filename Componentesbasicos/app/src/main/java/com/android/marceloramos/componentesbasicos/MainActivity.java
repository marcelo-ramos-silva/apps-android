package com.android.marceloramos.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoProduto;
    private TextView resultadoText, resultadoCB;
    private CheckBox cbBranco, cbVerde, cbVermelho;
    List<String> check = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById(R.id.idNomeProduto);
        resultadoText = findViewById(R.id.idResultadoText);
        resultadoCB = findViewById(R.id.idResultadoCB);
        cbBranco = findViewById(R.id.idCBBranco);
        cbVerde = findViewById(R.id.idCBVerde);
        cbVermelho = findViewById(R.id.idCBVermelho);
    }

    //recupera texto do EditText
    public void capituraText(){
        String nomeProduto = campoProduto.getText().toString();
        resultadoText.setText("Nome do Produto: " + nomeProduto + "\n");
    }

    public void verificaCheck(){
        check.clear();

        if(cbBranco.isChecked()){
            check.add(cbBranco.getText().toString());
        }

        if(cbVerde.isChecked()){
            check.add(cbVerde.getText().toString());
        }

        if(cbVermelho.isChecked()){
            check.add(cbVermelho.getText().toString());
        }

        resultadoCB.setText("Cor do Produto: " + check.toString());
    }

    public void btEnviar(View view){
        capituraText();
        verificaCheck();
    }
}

package com.android.marceloramos.appalcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.idPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.idPrecoGasolina);
        textResultado = findViewById(R.id.idResultado);
    }

    public void calcularPreco(View view){

        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            calcularMelhorPreco(precoAlcool, precoGasolina);
        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        //Converter valores string para números
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        //calculo para verificar a melhor opção
        Double resultado = precoAlcool / precoGasolina;
        if(resultado >= 0.7){
            textResultado.setText("Melhor utilizar Gasolina!");
        }else{
            textResultado.setText("Melhor utilizar Álcool");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}

package com.android.marceloramos.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoProduto;
    private TextView resultadoText, resultadoCB, resultadoRB;
    private CheckBox cbBranco, cbVerde, cbVermelho;
    List<String> check = new ArrayList<String>();
    private RadioGroup rgEstoque;
    private ToggleButton toogleEstado;
    private Switch switchEstado;
    private CheckBox checkEstado;
    private TextView resultadoToogle, resultadoSwitch, resultadoCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById(R.id.idNomeProduto);
        resultadoText = findViewById(R.id.idResultadoText);
        resultadoCB = findViewById(R.id.idResultadoCB);
        resultadoRB = findViewById(R.id.idResultadoRB);

        cbBranco = findViewById(R.id.idCBBranco);
        cbVerde = findViewById(R.id.idCBVerde);
        cbVermelho = findViewById(R.id.idCBVermelho);
        rgEstoque = findViewById(R.id.idRGEstoque);

        toogleEstado = findViewById(R.id.idToggleButton);
        switchEstado = findViewById(R.id.idSwitch);
        checkEstado = findViewById(R.id.idCheckBox);
        resultadoToogle = findViewById(R.id.idResultadoToogle);
        resultadoSwitch = findViewById(R.id.idResultadoSwitch);
        resultadoCheckBox = findViewById(R.id.idResultadoCheckBox);
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

    public void verificaRadioButton(){

        rgEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup ragioGroup, int i) {
                if(i == R.id.idRBSim){
                    resultadoRB.setText("Sim");
                }else{
                    resultadoRB.setText("Não");
                }
            }
        });
    }

    public void verificaToogle(){

        if(toogleEstado.isChecked()){
            resultadoToogle.setText("toogleButton ligado\n");
        }else{
            resultadoToogle.setText("toogleButton desligado\n");
        }
    }

    public void verificaSwitch(){

        if(switchEstado.isChecked()){
            resultadoSwitch.setText("switch ligado\n");
        }else{
            resultadoSwitch.setText("switch desligado\n");
        }
    }

    public void verificaCheckBox(){

        if(checkEstado.isChecked()){
            resultadoCheckBox.setText("checkBox ligado\n");
        }else {
            resultadoCheckBox.setText("checkBox desligado\n");
        }
    }

    public void btEnviar(View view){

        Toast.makeText(getApplicationContext(), "Botão pressionado", Toast.LENGTH_LONG).show();

        /*
        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagem);
        toast.show();
        */

        capituraText();
        verificaCheck();
        verificaRadioButton();
        verificaToogle();
        verificaSwitch();
        verificaCheckBox();
    }
}

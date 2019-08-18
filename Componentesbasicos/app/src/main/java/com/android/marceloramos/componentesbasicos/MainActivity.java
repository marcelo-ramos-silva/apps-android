package com.android.marceloramos.componentesbasicos;

import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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

    private SeekBar seekBar;
    private TextView textProgresso;

    private ProgressBar progressBar, progressBarCarregando;
    private int progresso = 0;

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

        seekBar = findViewById(R.id.idSeekBar);
        textProgresso = findViewById(R.id.idTextProgresso);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textProgresso.setText("Progresso: " + seekBar.getProgress() + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar alterado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar não está pressionado", Toast.LENGTH_SHORT).show();
            }
        });

        progressBar = findViewById(R.id.idProgressBar);
        progressBarCarregando = findViewById(R.id.idProgressBarCarregando);

        progressBarCarregando.setVisibility(View.GONE);
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

        //Toast.makeText(getApplicationContext(), "Botão pressionado", Toast.LENGTH_LONG).show();

        /*
        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagem);
        toast.show();
        */

        //criar AlertDialog
        /*AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //configurar titulo e mensagem

        dialog.setTitle("AlertDialog");
        dialog.setMessage("Deseja enviar as informações selecionadas?");

        //configurar cancelamento

        dialog.setCancelable(false);

        //configurar ícone

        dialog.setIcon(android.R.drawable.ic_delete);

        //configurar ações para botão sim ou não

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                Toast.makeText(getApplicationContext(), "Sim foi pressionado", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Não foi pressionado", Toast.LENGTH_SHORT).show();
            }
        });

        //criar e exibir AlertDialog

        dialog.create();
        dialog.show();*/

        //progressBar

        //this.progresso = this.progresso + 10;
        //progressBar.setProgress(this.progresso);

        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i <= 100; i++){

                    System.out.println(i);

                    final int progress = i;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);

                            if(progress == 100){
                                progressBarCarregando.setVisibility(View.GONE);
                            }
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //progressBarCarregando

        progressBarCarregando.setVisibility(View.VISIBLE);

        capituraText();
        verificaCheck();
        verificaRadioButton();
        verificaToogle();
        verificaSwitch();
        verificaCheckBox();
    }
}

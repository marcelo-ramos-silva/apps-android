package com.android.marceloramos.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private SeekBar seekBar;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private double porcentGorjeta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.idEditValor);
        seekBar = findViewById(R.id.idSeekBar);
        textPorcentagem = findViewById(R.id.idPorcentagem);
        textGorjeta = findViewById(R.id.idGorjeta);
        textTotal = findViewById(R.id.idTotal);

        //configurar SeekBar

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                porcentGorjeta = seekBar.getProgress();
                textPorcentagem.setText(Math.round(porcentGorjeta) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        //recuperar valor digitado
        double valorDigitado = Double.parseDouble(editValor.getText().toString());

        //calcular gorjeta total
        double gorjeta = valorDigitado * (porcentGorjeta/100);
        double total =  gorjeta + valorDigitado;

        //exibir gorjeta total
        textGorjeta.setText("R$ " + Math.round(gorjeta));
        textTotal.setText("R$ " + total);
    }
}

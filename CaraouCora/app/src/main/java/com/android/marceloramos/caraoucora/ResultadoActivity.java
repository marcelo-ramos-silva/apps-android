package com.android.marceloramos.caraoucora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private Button buttonVoltar;
    private ImageView imagemResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        buttonVoltar = findViewById(R.id.idButtonVoltar);
        imagemResultado = findViewById(R.id.idImageResultado);

        //recuperar dados
        Bundle dados = getIntent().getExtras();
        int num = dados.getInt("numero");

        if(num == 0){
            imagemResultado.setImageResource(R.drawable.moeda_cara);
        }else{
            imagemResultado.setImageResource(R.drawable.moeda_coroa);
        }

        //evento de clique para botão voltar
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

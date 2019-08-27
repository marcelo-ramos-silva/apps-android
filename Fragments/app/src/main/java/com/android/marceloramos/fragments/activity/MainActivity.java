package com.android.marceloramos.fragments.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.marceloramos.fragments.R;
import com.android.marceloramos.fragments.fragment.ContatosFragment;
import com.android.marceloramos.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa, buttonContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConversa = findViewById(R.id.idButtonConversa);
        buttonContato = findViewById(R.id.idButtonContato);

        //remover sombra da actionBar
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();

        //configurar objeto para fragmento
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.idFrameConteudo, conversasFragment);
        transaction.commit();

        buttonContato.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.idFrameConteudo, contatosFragment);
                transaction.commit();
            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.idFrameConteudo, conversasFragment);
                transaction.commit();
            }
        });
    }
}

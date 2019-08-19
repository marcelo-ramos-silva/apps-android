package com.android.marceloramos.componentesdelistagem.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.marceloramos.componentesdelistagem.R;

public class MainActivity extends AppCompatActivity {

    /*
    private ListView listLocais;

    private String[] itens = {
            "Angra dos Reis", "Caldas Novas", "Campos do Jordão",
            "Costa do Sauípe", "Ilhéus", "Porto Seguro",
            "Tiradentes", "Praga", "Santiago", "Zurique",
            "Caribe", "Buenos Aires", "Budapeste", "Cancún", "Aruba"
    }; */

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        listLocais = findViewById(R.id.idListView);

        //criar adaptador para lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1, itens
        );

        //adicionar adaptador para a lista
        listLocais.setAdapter(adaptador);

        //adicionar clique na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String valorSelecionado = listLocais.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });
        */

        recyclerView = findViewById(R.id.idRecyclerView);

        //configurar adapter


        //  configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter();
    }
}

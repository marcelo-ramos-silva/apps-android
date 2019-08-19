package com.android.marceloramos.componentesdelistagem.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.marceloramos.componentesdelistagem.R;
import com.android.marceloramos.componentesdelistagem.activity.RecyclerItemClickListener;
import com.android.marceloramos.componentesdelistagem.activity.adapter.Adapter;
import com.android.marceloramos.componentesdelistagem.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

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
    private List<Filme> listaFilmes = new ArrayList<>();

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

        //listagem de filmes
        this.criarFilmes();

        //configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        //  configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //configurar evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Item pressionado: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Click longo: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                })
        );
    }

    public void criarFilmes(){

        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civíl", "Aventura/Ficção","2016");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O filme", "Comédia/Animação","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu Malvado Favorito 3", "Comédia","2017");
        this.listaFilmes.add(filme);
    }
}

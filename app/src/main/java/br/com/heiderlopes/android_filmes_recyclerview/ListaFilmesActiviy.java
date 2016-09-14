package br.com.heiderlopes.android_filmes_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.heiderlopes.android_filmes_recyclerview.adapter.FilmesAdapter;
import br.com.heiderlopes.android_filmes_recyclerview.decoration.DividerItemDecoration;
import br.com.heiderlopes.android_filmes_recyclerview.listener.ClickListener;
import br.com.heiderlopes.android_filmes_recyclerview.listener.RecyclerTouchListener;
import br.com.heiderlopes.android_filmes_recyclerview.model.Filme;

public class ListaFilmesActiviy extends AppCompatActivity {
    private List<Filme> filmes = new ArrayList<>();
    private RecyclerView recyclerView;
    private FilmesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes_activiy);

        //Faz o bind com o layout
        recyclerView = (RecyclerView) findViewById(R.id.rvFilmes);

        //Cria a instancia do adapter passando a lista de filmes
        mAdapter = new FilmesAdapter(filmes);

        //Indica o layout a ser utilizado pelo nosso recyclerview, nesse exemplo
        //será criado uma lista (LinearLayoutManager)
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Adicionando nosso divider customizado
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        //Adicionando o listener para saber qual item foi clicado
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Filme filme = filmes.get(position);
                Toast.makeText(getApplicationContext(), filme.getNome(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        preparaFilmesFake();
    }

    //Cria filmes para popular a lista
    private void preparaFilmesFake() {
        Filme filme;
        for (int i = 0; i < 15; i++) {
            filme = new Filme("Nome do Filme " + i, "Genero " + 1, 2016);
            filmes.add(filme);
        }
        //Notifica o adapter que houve alteração na lista de dados
        mAdapter.notifyDataSetChanged();
    }
}
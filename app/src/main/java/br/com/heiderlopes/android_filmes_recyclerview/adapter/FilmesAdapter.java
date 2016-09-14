package br.com.heiderlopes.android_filmes_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.heiderlopes.android_filmes_recyclerview.R;
import br.com.heiderlopes.android_filmes_recyclerview.model.Filme;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.FilmeViewHolder> {

    //Lista de filmes que serão mostrados na lista
    private List<Filme> filmes;

    public FilmesAdapter(List<Filme> filmes) {
        this.filmes = filmes;
    }

    //O design pattern chamado ViewHolder que irá segurar as informações da view.
    //Aqui fazemos o bind dos atributos com os campos do nosso layout que representara
    //as linhas
    public class FilmeViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNome, tvAno, tvGenero;

        public FilmeViewHolder(View view) {
            super(view);
            tvNome = (TextView) view.findViewById(R.id.tvNome);
            tvGenero = (TextView) view.findViewById(R.id.tvGenero);
            tvAno = (TextView) view.findViewById(R.id.tvAno);
        }
    }

    // Aqui criamos o nosso ViewHolder, observe que nesse método
    // informamos qual o layout que devera ser utilizado
    // Ou seja podemos trabalhar com layouts diferentes de acordo
    // com uma determinada condição por exemplo
    @Override
    public FilmeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filme_lista, parent, false);

        return new FilmeViewHolder(itemView);
    }

    //Adicionamos os valores dos objetos na view
    @Override
    public void onBindViewHolder(FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.tvNome.setText(filme.getNome());
        holder.tvGenero.setText(filme.getGenero());
        holder.tvAno.setText(String.valueOf(filme.getAno()));
    }

    //Total de itens na nossa lista
    @Override
    public int getItemCount() {
        return filmes.size();
    }
}
package br.com.heiderlopes.android_filmes_recyclerview.listener;

import android.view.View;

//Interface que servirá de contrato
//para listener de cliques
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
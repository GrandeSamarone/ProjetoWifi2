package com.example.fulanoeciclano.projetowifi.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.fulanoeciclano.projetowifi.DAO.WifiDAO;
import com.example.fulanoeciclano.projetowifi.R;
import com.example.fulanoeciclano.projetowifi.RecicleView.wifiAdapterRec;
import com.example.fulanoeciclano.projetowifi.Wifi_Configuração.Wifi;

public class Mostrar_wifi_cadastrado extends Activity  {

    private Button BotaoMaisWifi;
    private Intent intentaddwifi;
    public Wifi wiFi;
    public Intent cad_anuncio;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_cad);
        configurarRecycler();
        BotaoMaisWifi = (Button) findViewById(R.id.botaomaiswifi);
        BotaoMaisWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentaddwifi = new Intent(Mostrar_wifi_cadastrado.this,MainActivity.class);
                startActivity(intentaddwifi);
            }
        });



    }



    RecyclerView recyclerView;
    private wifiAdapterRec adapter;
    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        WifiDAO dao = new WifiDAO(this);
        adapter = new wifiAdapterRec(dao.retornarwifi());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


    protected void onResume(){
        super.onResume();
        configurarRecycler();
    }




}


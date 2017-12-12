package com.example.fulanoeciclano.projetowifi.RecicleView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fulanoeciclano.projetowifi.Modelo.Wifi_modelo;
import com.example.fulanoeciclano.projetowifi.R;

import java.util.List;

/**
 * Created by NETINHO RIBEIRO on 04/12/2017.
 */

public class wifiAdapterRec extends RecyclerView.Adapter<WifiHolder> {

    private final List<Wifi_modelo> wifi_modelo;


    public wifiAdapterRec(List<Wifi_modelo> wifi_modelo) {
        this.wifi_modelo = wifi_modelo;

    }

    public WifiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WifiHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_cad, parent, false));
    }

    @Override
    public void onBindViewHolder(WifiHolder holder, int position) {
        holder.nomewifi.setText(wifi_modelo.get(position).getNome_wifi());
        holder.botaoanunciar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("123","teste do botao");
            }
        });
    }

    public int getItemCount() {
        return wifi_modelo != null ? wifi_modelo.size() : 0;
    }
}

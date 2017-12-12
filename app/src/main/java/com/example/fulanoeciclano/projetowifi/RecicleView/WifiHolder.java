package com.example.fulanoeciclano.projetowifi.RecicleView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fulanoeciclano.projetowifi.R;

/**
 * Created by NETINHO RIBEIRO on 04/12/2017.
 */

public class WifiHolder extends  RecyclerView.ViewHolder {

    public TextView nomewifi;
   public Button botaoanunciar;

    public WifiHolder(View itemView) {
        super(itemView);
    nomewifi = itemView.findViewById(R.id.nomeWifi);
    botaoanunciar = (Button) itemView.findViewById(R.id.botaoanunciar);


    }
}

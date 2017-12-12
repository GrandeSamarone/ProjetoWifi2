package com.example.fulanoeciclano.projetowifi.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fulanoeciclano.projetowifi.DAO.WifiDAO;
import com.example.fulanoeciclano.projetowifi.R;
import com.example.fulanoeciclano.projetowifi.Wifi_Configuração.Wifi;

import java.util.List;
//import com.example.fulanoeciclano.projetowifi.Adapter.ListAdapter;

public class MainActivity extends Activity implements OnClickListener, Wifi.WiFiListener, AdapterView.OnItemClickListener {

    private Wifi wiFi;
    private ListView list;
    private Button BotaoProx;

    private List<ScanResult> scans;

    private ListAdapter listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.botao).setOnClickListener(this);
        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

    }


   public void onClick(View view) {
        Toast.makeText(this, "Buscando....", Toast.LENGTH_LONG).show();
        //Inicia a Busca...
        wiFi = Wifi.startScanWIFI(this, this);
    }


    public void onItemClick(AdapterView<?> arg0, View arg1, final int position, long arg3) {


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //Pega o nome do Wifi para mostrar na janela
        alert.setTitle("Wifi");
        final String Nome_Wifi_Selecionado = (scans.get(position).SSID.toString());

        alert.setMessage(Nome_Wifi_Selecionado);
        // Variavel que armazena a senha
        final EditText Cad_senha_selecionado = new EditText(this);
        alert.setView(Cad_senha_selecionado );

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                // CONFIGURAÇÃO DA SENHA
                WifiConfiguration wifiConfiguration = new WifiConfiguration();
                wifiConfiguration.BSSID = scans.get(position).BSSID;
                wifiConfiguration.SSID = "\"" + scans.get(position).SSID + "\"";
                wifiConfiguration.preSharedKey = String.valueOf(Cad_senha_selecionado );


                //Conecto na nova rede criada.
                WifiManager wifiManager = wiFi.getWifiManager(MainActivity.this);
                int netId = wifiManager.addNetwork(wifiConfiguration);
                wifiManager.saveConfiguration();
                wifiManager.disconnect();
                wifiManager.enableNetwork(netId, true);
                wifiManager.reconnect();
            }
        });

        //inserir o nome do wifi ao banco
        WifiDAO dao = new WifiDAO(this);
        dao.insere(Nome_Wifi_Selecionado, String.valueOf(Cad_senha_selecionado));
        dao.close();



        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });

        alert.show();

    }


//RESULTADO DO WIFI E JOGA NO LIST ADAPTER
    public void onResultScan(Context arg0, Intent arg1, List<ScanResult> results) {
        scans = results;

        listAdapter = new com.example.fulanoeciclano.projetowifi.Adapter.ListAdapter(this,scans);

        list.setAdapter(listAdapter);

    }

}
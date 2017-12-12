package com.example.fulanoeciclano.projetowifi.Modelo;

public class Wifi_modelo {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_wifi() {
        return nome_wifi;
    }

    public void setNome_wifi(String nome_wifi) {
        this.nome_wifi = nome_wifi;
    }

    public Double getSenha_wifi() {
        return senha_wifi;
    }


    @Override
    public String toString() {
        return getNome_wifi();
    }

    private String nome_wifi;
    private Double senha_wifi;

}

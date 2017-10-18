package com.example.klaus.pruebafirebase.Objetos;

/**
 * Created by klaus on 18/10/2017.
 */

public class Carro {

    String marca;
    String dueno;
    int puertas;
    int ruedas;

    public Carro() {
    }

    public Carro(String marca, String dueno, int puertas, int ruedas) {
        this.marca = marca;
        this.dueno = dueno;
        this.puertas = puertas;
        this.ruedas = ruedas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}

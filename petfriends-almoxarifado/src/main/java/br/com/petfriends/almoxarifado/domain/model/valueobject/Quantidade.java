package br.com.petfriends.almoxarifado.domain.model.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Quantidade {

    private int valor;

    protected Quantidade() {
    }

    public Quantidade(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

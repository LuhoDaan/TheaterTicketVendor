package com.company;
public class Palco implements Seat {
    private int posizionePosto;
    private Boolean postoNonOccupato = Boolean.TRUE;
    private double prezzo = 120;


    @Override
    public Boolean isSeatAvailable() {
        return this.postoNonOccupato;
    }

    @Override
    public void reserveSeat() {
        if (this.postoNonOccupato.equals(Boolean.TRUE)) {
            this.postoNonOccupato = Boolean.FALSE;
        } else System.out.println("Il posto desiderato non è disponibile");

    }

    @Override
    public Double accept(Biglietteria biglietteria) {
        return biglietteria.visit(this);
    }

    @Override
    public Double returnPriceOfTheSeat() {
        return prezzo;
    }

}


package com.company;
public abstract class Ticket {
    String ticketName = "";
    int ticketNumber;
    Double prezzoBiglietto;


    public abstract Double getPrezzoBiglietto();

    public void setPrezzoBiglietto(Double prezzo){
        this.prezzoBiglietto = prezzo;
    }


    public String getTicketName() {
        return this.ticketName;
    }

    @Override
    public String toString() {
        return getTicketName() + " Prezzo €" + getPrezzoBiglietto() ;
    }
}
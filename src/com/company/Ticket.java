package com.company;
public abstract class Ticket {
    String ticketName = "";
    int ticketNumber;
    static int lastTicketNumber = 0;
    Double prezzoBiglietto;

    public  int generateTicketNumber() {
        this.ticketNumber = lastTicketNumber + 1;
        lastTicketNumber = +1;
        return this.ticketNumber;
    }

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
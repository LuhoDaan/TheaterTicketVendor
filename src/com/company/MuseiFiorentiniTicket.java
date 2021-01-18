package com.company;
public class MuseiFiorentiniTicket extends ExtraScontoTicket {
    public MuseiFiorentiniTicket(Ticket ticket){
        this.ticket = ticket;
        this.ticketName = " Musei Fiorentini / ";
        this.prezzoBiglietto =  - 1.0;
    }
    @Override
    public Double getPrezzoBiglietto() {
        return ticket.getPrezzoBiglietto() + this.prezzoBiglietto;
    }

    @Override
    public String getTicketName() {
        return ticket.getTicketName() + this.ticketName ;
    }
}



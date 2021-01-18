package com.company;
public class CoopTicket extends ExtraScontoTicket{
    public CoopTicket(Ticket ticket){
        this.ticket = ticket;
        this.ticketName =  " Coop /";
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

package com.company;
public interface Seat {
    public Boolean isSeatAvailable();
    public void reserveSeat();
    public Double accept (Biglietteria biglietteria);
    public Double returnPriceOfTheSeat();
    
}

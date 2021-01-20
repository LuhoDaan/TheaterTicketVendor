package com.company;
public interface Seat {
     Boolean isSeatAvailable();
     void reserveSeat();
     Double accept (Biglietteria biglietteria);
     Double returnPriceOfTheSeat();
    
}

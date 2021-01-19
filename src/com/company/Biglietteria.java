package com.company;
// visitor
public interface Biglietteria {
    Double visit (Palco postoPalco);
    Double visit (Platea postoPlatea);
    void buy() throws TeatroNotInitialized;



}

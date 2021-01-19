/*
public class TeatroDellaPergola {
    private static TeatroDellaPergola instance;
    private static final Seat seatsList[][] = new Seat[11][30];
    private String programmazioneDellaSettimana;
    private String orarioSpettacoli;

    private  TeatroDellaPergola(){
        for (int i=0; i<11; i++ ){
            for(int j=0; j<30; j++){
                if( j<3 || j>27 ) {
                    seatsList[i][j] = new Palco();
                }
                else
                    seatsList[i][j] = new Platea();

            }

        }

    }
    public static TeatroDellaPergola getInstanceOf(){
        if(instance == null){
            instance = new TeatroDellaPergola();
        }
        return instance;

    }


    public void setProgrammazioneDellaSettimana(String programmazioneDellaSettimana) {
        this.programmazioneDellaSettimana = programmazioneDellaSettimana;
    }

    public void setOrarioSpettacoli(String orarioSpettacoli) {
        this.orarioSpettacoli = orarioSpettacoli;
    }

    public String getProgrammazioneDellaSettimana() {
        return programmazioneDellaSettimana;
    }

    public String getOrarioSpettacoli() {
        return orarioSpettacoli;
    }

    public void setSeatsList() {

    }
   // public void showInformationAboutTheShow(){
        //come fare per settare una sorta di locandina per lo spettacolo ?
    //}

    public static Seat getSeatList(int row, int column ) {
        return seatsList[row][column];
    }
}
*/

////////////////////////////////////
package com.company;
public class Teatro {
    private static Teatro instance;
    private static Seat[][] seats;
    private static String name;
    private String programmazioneDellaSettimana;
    private String orarioSpettacoli;


    private Teatro() {
        // La classe di solito esprime un concetto astratto
        // l'oggetto è la realizzazione concreta del concetto.
        // Anche se qui hai un singleton potresti in futuro cambiare le cose
        // e espandere l'applicazione a più teatri,
        // quindi tenere la cosa più astratta possibile può aiutare

    }


    public static Teatro getInstanceOf() throws TeatroNotInitialized {
        if (instance == null) {
            if (name != null && seats[0].length != 0) {
                // così va prima impostata per bene la classe e poi restituita l'instance
                instance = new Teatro();
            } else
                throw new TeatroNotInitialized(name, seats);
        }
        return instance;

    }

    public static void setLayoutTeatro(int rows, int cols, int[] plateaIndexes) {
        seats = new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < plateaIndexes[0] || j > plateaIndexes[1]) {
                    seats[i][j] = new Palco();
                } else
                    seats[i][j] = new Platea();
            }
        }
    }

    public void setProgrammazioneDellaSettimana(String programmazioneDellaSettimana) {
        this.programmazioneDellaSettimana = programmazioneDellaSettimana;
    }

    public void setOrarioSpettacoli(String orarioSpettacoli) {
        this.orarioSpettacoli = orarioSpettacoli;
    }

    public String getProgrammazioneDellaSettimana() {
        return programmazioneDellaSettimana;
    }

    public String getOrarioSpettacoli() {
        return orarioSpettacoli;
    }



    public Seat getSeat(int row, int column) {
        return seats[row][column];
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public String getName() {
        return Teatro.name;
    }

    public static void setName(String name) {
        Teatro.name = name;
    }

}


// implementazione user-defined Exception,
// per lanciare eccezioni se non hai settato i dati del teatro prima
class TeatroNotInitialized extends Exception {
    private String name;
    private Seat[][] seats;

    public TeatroNotInitialized(String name, Seat[][] seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public Seat[][] getSeats() {
        return seats;
    }

}
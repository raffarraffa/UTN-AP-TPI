package models;

public class Partido {
    private String equipo1;
    private String equipo2;
    private ResultadoEnum ganador;
    private int goles_equipo_1;
    private int goles_equipo_2;

    public Partido(String equipo1, String equipo2,  int goles_equipo_1, int goles_equipo_2,ResultadoEnum ganador ) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganador = ganador;
        this.goles_equipo_1 = goles_equipo_1;
        this.goles_equipo_2 = goles_equipo_2;
    }
}

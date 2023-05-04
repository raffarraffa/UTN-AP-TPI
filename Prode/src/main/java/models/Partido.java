package models;

public class Partido {
    private String equipo1;
    private String equipo2;
    private ResultadoEnum ganador;
    private int goles_equipo_1;
    private int goles_equipo_2;
    private int ronda;

    public Partido(String equipo1, String equipo2,  int goles_equipo_1, int goles_equipo_2,ResultadoEnum ganador,int ronda ) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganador = ganador;
        this.goles_equipo_1 = goles_equipo_1;
        this.goles_equipo_2 = goles_equipo_2;
        this.ronda=ronda;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public int getGoles_equipo_1() {
        return goles_equipo_1;
    }

    public int getGoles_equipo_2() {
        return goles_equipo_2;
    }

    public int getRonda() {
        return ronda;
    }
    public ResultadoEnum getGanador(){
        return ganador;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "equipo1='" + equipo1 + '\'' +
                ", equipo2='" + equipo2 + '\'' +
                ", ganador=" + ganador +
                ", goles_equipo_1=" + goles_equipo_1 +
                ", goles_equipo_2=" + goles_equipo_2 +
                ", ronda=" + ronda +
                '}';
    }
}

package AP.JAVA.modelos;

public class Partido {
    private String equipo_1;
    private String equipo_2;
    private String goles_1;
    private String goles_2;
    private String ganador;
    private String prono_ganador;

    public Partido(String equipo_1, String equipo_2, String goles_1, String goles_2, String ganador, String prono_ganador) {
        this.equipo_1 = equipo_1;
        this.equipo_2 = equipo_2;
        this.goles_1 = goles_1;
        this.goles_2 = goles_2;
        this.ganador = ganador;
        this.prono_ganador = prono_ganador;

    }
/*public String verPartido(String partido){
        return
}*/
    @Override
    public String toString() {
        return "Partido{" +
                "equipo_1='" + equipo_1 + '\'' +
                ", equipo_2='" + equipo_2 + '\'' +
                ", goles_1='" + goles_1 + '\'' +
                ", goles_2='" + goles_2 + '\'' +
                ", ganador='" + ganador + '\'' +
                ", prono_ganador='" + prono_ganador + '\'' +
                '}';
    }
}

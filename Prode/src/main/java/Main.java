package AP;

import models.*;

import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        // data: rondas, partidos, resultados
        Data partidos = new Data();// manipulacion csv partidos
        Rondas rondas=new Rondas();
        partidos.setDataFromCSV("E:/Estudio/UTN java/UTN-TP-integrador-Final/UTN-AP-TPI/Prode/src/data" +
                "/resultados_mundial.csv", ";", true);
        rondas.setRondas((ArrayList<String[]>) partidos.getData()); // obtiene los datos de partidos como arraylist
        // evaluandolos para RONDAS

        System.out.println(rondas.getDatos_ronda().size());
        System.out.println("cantidad rondas " + rondas.getDatos_ronda().size());
        for (String ronda : rondas.getDatos_ronda().keySet()) {
            System.out.println("cantidad partidos en ronda "+ ronda +" : " + rondas.getDatos_ronda().get(ronda));
        }
        //System.out.println(rondas.getPartidos_ronda());
        System.out.println("liena29");
      //  System.out.println(rondas.getRondas());
        for (String ronda : rondas.getRondas().keySet()) {
            System.out.println(ronda);
            HashMap<String, Partido> ron = rondas.getRondas().get(ronda);
            for (String r : ron.keySet()) {
                System.out.println(ron.get(r).getGanador());
//                System.out.println(ron.get(r).toString());
            }
        }

/*        for (String[] partido:partidos.getData()) {
            System.out.println(partido[0]);
            System.out.println(partido[1]);
            System.out.println(partido[2]);
            System.out.println(partido[3]);

        }*/
    }
}

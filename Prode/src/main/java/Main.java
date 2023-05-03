package AP;

import models.Data;
import models.Equipo;
import models.Partido;
import models.ResultadoEnum;

import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {
        HashSet<String> equipos = new HashSet<>();
 //       ArrayList<Partido> partidos =new ArrayList<Partido>();
        // R1: gana equipo 1, R2 ganar equipo 2, R0 empate
        //HashMap<String, Partido> partidos = new HashMap<String, Partido>();
        HashMap<String, ResultadoEnum> resultado_partidos = new HashMap<String, ResultadoEnum>();
        Data datos_equipos= new Data();
        datos_equipos.setDataFromCSV("E:/Estudio/UTN java/UTN-TP-integrador-Final/UTN-AP-TPI/Prode/src/data/resultados_mundial.csv",";",true);

           for (String[] equipo:datos_equipos.getData()) {
                //inicializo variable resultado enum
               ResultadoEnum resultado;
               // calculo resultado
               int resul_aux =Integer.parseInt(equipo[3]) - Integer.parseInt(equipo[4]);
               if(resul_aux > 0){
                   resultado=ResultadoEnum.R1;
               } else if (resul_aux < 0) {
                   resultado=ResultadoEnum.R2;
               }else{
                   resultado=ResultadoEnum.R0;
               }
                //Intancio partido (String equipo1, String equipo2, String ganador, int goles_equipo_1, int goles_equipo_2)
 //              Partido partido = new Partido(equipo[2],equipo[5],Integer.parseInt(equipo[3]),Integer.parseInt(equipo[4]),resultado);
              resultado_partidos.put((equipo[2]+"-"+equipo[5]),resultado);
//            for (int i = 0; i < equipo.length; i++) {
//                (0: fecha, 1 grupo, 2: equipo1, 3: gol equip 1, 4 :gol equipo2, 5:equipo 2)
//                equipos.add(equipo[2]);
//                equipos.add(equipo[5]);
//                System.out.print(equipo[2]+ " - ");
//                System.out.print(equipo[5]+" : ");
//                System.out.print(Integer.parseInt(equipo[3]) - Integer.parseInt(equipo[4]));
//                System.out.print(equipo[i]+" , ");
 //          }
               System.out.println();

            // System.out.println(datos_equipos.getData());
            // System.out.println(datos_equipos.toString());

        }
        System.out.println(resultado_partidos);
    }
}
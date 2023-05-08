package AP.JAVA;

import AP.JAVA.modelos.Pronosticos;
import AP.JAVA.modelos.Ronda;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Long  INICIO= System.currentTimeMillis();

        /** RONDA (SE INSTANCIA Ronda  SE GUARDAN PARTIDOS  ALLI) **/
        Ronda ronda=new Ronda();
        /** PRONOSTICOS (se insatncia pronsoticos y se guardan alli los vlaores, luego d eobtendran puntos)  **/
        Pronosticos pronosticos =new Pronosticos();
        /** estos datos deberia venir como arg , pero no se donde ponerlo en el IDE **/
        String path_resultados="E:/Estudio/UTN java/UTN-TP-integrador-Final/PRODE/src/main/java/AP/JAVA/datos/resultados_mundial.csv";
        String path_pronosticos="E:/Estudio/UTN java/UTN-TP-integrador-Final/PRODE/src/main/java/AP/JAVA/datos/pronostico_2.csv";
        E:\Estudio\UTN java\UTN-TP-integrador-Final\Prode-Final\src\main\java\AP\JAVA\datos\pronostico_2.csv
        // separador de datos
        String separador=";";
        // para decirle la metodo si procsa primera linea
        boolean primera_linea= false;
        //procesa los resultados partidos
        ronda.setDesdeCSV(path_resultados, ";", true);
        pronosticos.setDesdeCSV(path_pronosticos, ";", true);
        //pronosticos.verData();
        pronosticos.calcularPuntos(ronda);
        pronosticos.verData();
        /* CONTROL TIEMPOS Y EXIT */
        System.out.println();
        System.out.println("****************************");
        System.out.println("/* CONTROL TIEMPOS Y EXIT */");
        System.out.println("****************************");
        Long  FIN= System.currentTimeMillis();
        System.out.println("INICIO=" + INICIO);
        System.out.println("FIN=" + FIN);
        System.out.println("total proceso " +(FIN - INICIO)+ " millis");
        System.out.println("*****************************");
      }
}
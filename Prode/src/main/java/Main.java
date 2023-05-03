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
 //     seccion partidos resultados
        PartidosResultados resultados = new PartidosResultados();
        // la bandera primera liena permite considerar o no alprimer alinea del csv
        resultados.procesarData("E:/Estudio/UTN java/UTN-TP-integrador-Final/UTN-AP-TPI/Prode/src/data/resultados_mundial.csv", ";", true);
        System.out.println(resultados.getData());
// seccion pronosticos
        Pronostico pronostico= new Pronostico();
        System.out.println("---------------------------------*********************--------------------------------");
        // la bandera primera liena permite considerar o no alprimer alinea del csv
        pronostico.procesarData("E:/Estudio/UTN java/UTN-TP-integrador-Final/UTN-AP-TPI/Prode/src/data/pronostico.csv", ";", true);
        //pronostico.procesarData("E:/Estudio/UTN java/UTN-TP-integrador-Final/UTN-AP-TPI/Prode/src/data/pronostico.csv", ";", false);
        System.out.println(pronostico.getData());
        VerificarPronostico verify=new VerificarPronostico(resultados.getData(),pronostico.getData());
        verify.verificarPronostico();

    }
}
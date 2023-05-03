/**
 * Pronostico, lee un csv o y una base datos, valores, recorre rondas y pronosticador(dni)
 * devuelve puntos obtenidos
 */
package models;

import java.io.IOException;
import java.util.HashMap;

public class Pronostico {
    private HashMap<String, ResultadoEnum> pronosticos_partidos = new HashMap<String, ResultadoEnum>();
    public void procesarData(String archivo_path, String separador, boolean primera_linea,String dni, String ronda) throws IOException {
        Data datos_pronosticos= new Data();
        //datos_equipos.setDataFromCSV("E:/Estudio/UTN java/UTN-TP-integrador-Final/UTN-AP-TPI/Prode/src/data/resultados_mundial.csv",";",true);
        ResultadoEnum resultado;
        datos_pronosticos.setDataFromCSV(archivo_path, separador, primera_linea);
        for (String[] pronostico : datos_pronosticos.getData()) {
            //1;999911;Argentina;ARABIA SAUDÍ;R1
            // Se guardan en hashmap para busqueda (key equipo1-equipo2, valor resultadoEnum)
           // comparo busco ronda  y busco dni
            if(dni.equals(pronostico[1]) && ronda.equals(pronostico[0])) {
                String equipo_1 = pronostico[2].toUpperCase();
                String equipo_2 = pronostico[3].toUpperCase();
            try {
                resultado = ResultadoEnum.valueOf(pronostico[4].toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("El valor '" + pronostico[4] + "' no corresponde a ningún vlaor esperado de pronostico.");
                resultado = null;
            }
            if(resultado!=null) {
                this.pronosticos_partidos.put((equipo_1 + "-" + equipo_2), resultado);
            }else {
                System.out.println("Imposible procesar eroro en datos");
            }
            System.out.println();
        }


           // System.out.println(datos_pronosticos);
         //   datos_pronosticos=null;
    }
    public HashMap<String, ResultadoEnum> getData(){
        return pronosticos_partidos;
    }
}

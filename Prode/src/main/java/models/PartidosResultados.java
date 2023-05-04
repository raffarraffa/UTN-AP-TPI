package models;

import java.io.IOException;
import java.util.HashMap;

public class PartidosResultados {
    private HashMap<String, ResultadoEnum> resultado_partidos = new HashMap<>();
    public void procesarData(String archivo_path, String separador, boolean primera_linea) throws IOException {
        Data datos_equipos= new Data();
        //datos_equipos.setDataFromCSV("E:/Estudio/UTN java/UTN-TP-integrador-Final/UTN-AP-TPI/Prode/src/data/resultados_mundial.csv",";",true);
        ResultadoEnum resultado;
        datos_equipos.setDataFromCSV(archivo_path, separador, primera_linea);
        for (String[] equipo : datos_equipos.getData()) {
            // calculo resultado
            int resul_aux = Integer.parseInt(equipo[4]) - Integer.parseInt(equipo[5]);
            if (resul_aux > 0) {
                resultado = ResultadoEnum.R1;
            } else if (resul_aux < 0) {
                resultado = ResultadoEnum.R2;
            } else {
                resultado = ResultadoEnum.R0;
            }
            // Se guardan en hashmap para busqueda (key equipo1-equipo2, valor resultadoEnum)
            String equipo_1 = equipo[3].toUpperCase();
            String equipo_2 = equipo[6].toUpperCase();
            this.resultado_partidos.put((equipo_1 + "-" + equipo_2), resultado);
           System.out.println();
        }
        datos_equipos=null;
   }
    public HashMap<String, ResultadoEnum> getData(){
        return resultado_partidos;
    }
}

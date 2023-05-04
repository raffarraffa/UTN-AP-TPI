package models;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class Rondas {
//    private final HashSet<Integer> datos_ronda =new HashSet<>();
    private HashMap<String,Integer> datos_ronda =new HashMap<String, Integer>();
    private HashMap<String,HashMap<String,Partido>> rondas =new HashMap<String,HashMap<String,Partido>>();
//    private PartidosResultados partidos;
//    private ArrayList<Partido> partidos;
    private HashMap<String,Partido> partidos_ronda=new HashMap<String,Partido>();

    public Rondas() {
    }

    public HashMap<String, Integer> getDatos_ronda() {
        return datos_ronda;
    }

    public void setDatos_ronda(HashMap<String, Integer> datos_ronda) {
        this.datos_ronda = datos_ronda;
    }

    public HashMap<String, Partido> getPartidos_ronda() {
        return partidos_ronda;
    }
    public HashMap<String, HashMap<String, Partido>> getRondas() {
        return rondas;
    }

    public void setRondas(ArrayList<String[]> partidos) {

        for (String[] partido : partidos) {
           HashMap<String,Partido> partidos_rond=new HashMap<String,Partido>();

            if(datos_ronda.containsKey(partido[0])){
                datos_ronda.put(partido[0], datos_ronda.get(partido[0])+1);
            }else{
                datos_ronda.put(partido[0], 1);
            }

            ResultadoEnum resultado;
            int goles_1=Integer.parseInt(partido[4]);
            int goles_2=Integer.parseInt(partido[5]);
            int result=goles_1-goles_2;
            if(result>0){
                resultado=ResultadoEnum.R1;
            } else if (result < 0) {
                resultado=ResultadoEnum.R2;
            }else {
                resultado=ResultadoEnum.R0;
            }
            Partido part=new Partido(
                    partido[3],
                    partido[6],
                    goles_1,
                    goles_2,
                    resultado,
                    (parseInt(partido[0]))
            );
           if(rondas.containsKey(partido[0])) {
               partidos_rond = rondas.get(partido[0]);
           }
               //(String equipo1, String equipo2,  int goles_equipo_1, int goles_equipo_2,ResultadoEnum ganador,int ronda )
               partidos_rond.put((partido[3]+"-"+partido[6]),part);
               rondas.put(partido[0],partidos_rond);
           //}else{

          // }
        }
     }


    /* public void procesarRonda(String archivo_path, String separador, boolean primera_linea) throws IOException {
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
            this.partidos.put((equipo_1 + "-" + equipo_2), resultado);
            System.out.println();
        }
        datos_equipos=null;
    }*/
    public HashMap<String, Partido> getPartido(){
        return partidos_ronda;
    }

}

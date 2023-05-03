package models;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class VerificarPronostico {
    private HashMap <String,ResultadoEnum> pronosticos;
    private HashMap <String,ResultadoEnum> partidos;

    public VerificarPronostico(HashMap pronosticos, HashMap partidos) {
        this.pronosticos = pronosticos;
        this.partidos = partidos;
    }

    public void verificarPronostico() {
          int puntaje=0;
//        Set<Entry<String, ResultadoEnum>> entries = pronosticos.entrySet();
        for(HashMap.Entry<String,ResultadoEnum> partido :pronosticos.entrySet()){
            String clave =partido.getKey();
            ResultadoEnum resultado= partido.getValue();
            if (partidos.containsKey(clave) && partidos.get(clave).equals(resultado)) {
               System.out.println("EL partido " + clave + " y el resultador " + resultado + " coinciden, sumo 1 punto.");
               puntaje++;

            }
       System.out.println("*************************");
       System.out.println(partido.getKey());
       System.out.println(partido.getValue());
    }
        System.out.println(puntaje);
  }

    /*
        if (mapa2.containsKey("uno") && mapa2.get("uno").equals(mapa1.get("uno"))) {
        System.out.println("El par clave-valor \"uno\"-\"1\" se encuentra en el segundo mapa.");
    } else {
        System.out.println("El par clave-valor \"uno\"-\"1\" no se encuentra en el segundo mapa.");
    }
    */

}

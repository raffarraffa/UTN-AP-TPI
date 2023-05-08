package AP.JAVA.modelos;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Pronosticos implements DatosProde {
    private Map<String, ArrayList<String>> pronosticos;
    //<nombre persona ,<ronda,puntos>>
    private Map<String, HashMap<String,Integer>> pronosticos_puntos;
   public Pronosticos() {
        this.pronosticos = new HashMap<>();
        this.pronosticos_puntos = new HashMap<>();
    }
    @Override
    public void setDesdeCSV(String archivopath, String separador, boolean primer_linea) throws RuntimeException, IOException {
        File archivo = new File(archivopath);
        BufferedReader lineas = null;
        try {
            FileReader archivo_leido; // objeto lectura archivo
            archivo_leido = new FileReader(archivo);
            lineas = new BufferedReader(archivo_leido);
            // linea individual de CSV
            String linea="", pronostico="";
            while ((linea = lineas.readLine()) != null) {
                if (primer_linea) {
                    primer_linea = false;
                } else {
                    // ArrayList<String> registro = new ArrayList<>();
                    String[] linea_procesada = linea.split(separador);
                    pronostico= linea_procesada[2]+";"+linea_procesada[3]+";"+linea_procesada[4];
                    if (!this.pronosticos.containsKey(linea_procesada[1])){
                        this.pronosticos.put(linea_procesada[1], new ArrayList<String>());
                    }
                    this.pronosticos.get(linea_procesada[1]).add(pronostico);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (lineas != null) {
                lineas.close();
            }
        }
    }
    @Override
    public void verData() {
        System.out.println("***** pronosticos ****");
        System.out.println(this.pronosticos_puntos);
        List<String> claves_pronosticos =new ArrayList<>(this.pronosticos_puntos.keySet());
        Collections.sort(claves_pronosticos);
        for (String clave : claves_pronosticos) {
            System.out.println("***************");
            System.out.println(" Persona: "+ clave);
            List<String> claves_nombre = new ArrayList<>(this.pronosticos_puntos.get(clave).keySet());
            Collections.sort(claves_nombre);
            for (String clave_nombre : claves_nombre) {
                System.out.print("Ronda: " + clave_nombre);
                Integer puntos=(this.pronosticos_puntos.get(clave).get(clave_nombre));
                System.out.print(" Puntos -> " +  puntos);
                System.out.println();
            }
         }
    }
    @Override
    public Map getData(){
        return this.pronosticos;
    }
    public void calcularPuntos(Ronda ronda){

      //  ronda.verData();
        List<String> claves_pronosticos =new ArrayList<>(this.pronosticos.keySet());
        Map<String, ArrayList<String>> ron=ronda.getData();
        List<String> claves_rondas =new ArrayList<>(ron.keySet());
        for (String nombre : claves_pronosticos) {
            //Integer puntos=0;
            if(!this.pronosticos_puntos.containsKey(nombre)) {
                this.pronosticos_puntos.put(nombre, new HashMap<String, Integer>());
            }
            Set<String> prono = new HashSet<String>(this.pronosticos.get(nombre));// SET pronosticos para cada persona
            for (String clave_ronda : claves_rondas) {
                Integer puntos=0;
                for (String partido: ron.get(clave_ronda)) {
                    if(prono.contains(partido)){
                        puntos++;
                    }
                }
                this.pronosticos_puntos.get(nombre).put(clave_ronda,puntos);

            }



         //  System.out.println(clave+" : "+pronosticos.get(clave));


        }
//        Set<String> prono = new HashSet<String>(pronosticos);

       // System.out.println(ron);
//        Collections.sort(claves_rondas);
    //    for (String clave : claves_rondas) {
    //        System.out.println("Ronda "+clave);
     //       System.out.println(ron.get(clave));
        //    ArrayList<Partido> partidos =ron.get(clave);
         //   for (Partido partido: partidos) {
         //       System.out.println(partido.toString());
         //   }
        }


}
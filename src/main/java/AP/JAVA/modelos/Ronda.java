package AP.JAVA.modelos;

import java.io.*;
import java.util.*;


public class Ronda implements DatosProde {
    private Map<String, ArrayList<Partido>> ronda;
    private Map<String, ArrayList<String>> prono_ganador;

    public Ronda() {
        this.ronda = new HashMap<>();
        this.prono_ganador =new HashMap<>();
    }

    @Override
    public void setDesdeCSV(String archivopath, String separador, boolean primer_linea) throws RuntimeException, IOException {
        /* recibe csv, recibe separador y procesar o no primera linea */

        File archivo = new File(archivopath);
        BufferedReader lineas = null;
        try {
            FileReader archivo_leido; // objeto lectura archivo
            archivo_leido = new FileReader(archivo);
            lineas = new BufferedReader(archivo_leido);
            // linea individual de CSV
            String linea;
            while ((linea = lineas.readLine()) != null) {
                String resultado = "", prono_ganador="";
                Integer result;
                if (primer_linea) {
                    primer_linea = false;
                } else {
                    //              ArrayList<String> registro = new ArrayList<>();
                    String[] linea_procesada = linea.split(separador);
                    result = Integer.parseInt(linea_procesada[2]) - Integer.parseInt(linea_procesada[3]);

                        if (result > 0) {
                            resultado = String.valueOf(ResultadoEnum.R1);
                        } else if (result < 0) {
                            resultado = String.valueOf(ResultadoEnum.R2);
                        } else {
                            resultado = String.valueOf(ResultadoEnum.R0);
                        }
                        //1;JORGE;ESTADOS UNIDOS;GALES;R2
                     prono_ganador= linea_procesada[1]+";"+linea_procesada[4]+";"+resultado;

              /*      System.out.print(linea_procesada[1]);
                    System.out.print(" - ");
                    System.out.print(linea_procesada[4]);
                    System.out.print(" -> ");
                    System.out.print(resultado);
                    System.out.println();
               */
                    Partido partido = new Partido(linea_procesada[1], linea_procesada[4], linea_procesada[2], linea_procesada[3], resultado, prono_ganador);
                     if (!this.ronda.containsKey(linea_procesada[0])) {
                        this.ronda.put(linea_procesada[0], new ArrayList<Partido>());
                        }
                    this.ronda.get(linea_procesada[0]).add(partido);
                      if (!this.prono_ganador.containsKey(linea_procesada[0])) {
                        this.prono_ganador.put(linea_procesada[0], new ArrayList<String>());
                      }
                    this.prono_ganador.get(linea_procesada[0]).add(prono_ganador);
                }
            }
            } catch(FileNotFoundException e){
                throw new RuntimeException(e);
            } finally{
                if (lineas != null) {
                    lineas.close();
                }
            }
        }

    @Override
    public void verData() {
        List<String> claves_rondas =new ArrayList<>(this.ronda.keySet());
        Collections.sort(claves_rondas);
        for (String clave : claves_rondas) {
            System.out.println("Ronda "+clave);
            ArrayList<Partido> partidos =this.ronda.get(clave);
            for (Partido partido: partidos) {
                System.out.println(partido.toString());
            }
        }
   }
    @Override
    public Map getData(){
        return this.prono_ganador;
    }
   public void verpartidosRonda(String ronda){
       if(this.ronda.containsKey(ronda)){
           System.out.println(this.ronda.get(ronda).toString());
       }else{
           System.out.println("Error ronda no existente");
       }
   }
   public void verPartidosGanadoresRonda(String ronda) {
       if (this.ronda.containsKey(ronda)) {
           System.out.println(this.prono_ganador.get(ronda));
       } else {
           System.out.println("Error ronda no existente");
       }

   }
}


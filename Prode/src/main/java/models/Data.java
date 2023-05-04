package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private ArrayList<String[]> data;
    public Data() {
        this.data = new ArrayList<>();
    }
    public void setDataFromCSV(String archivopath,String separador, boolean primer_linea) throws IOException { // recibe csv y procesa segun parametros
        File archivo = new File(archivopath); //crear objeto desde archivo
        FileReader archivo_leido = new FileReader(archivo); // objeto lectura archivo
        BufferedReader lineas = new BufferedReader(archivo_leido);
        String linea;
        while((linea=lineas.readLine())!=null){
            if(primer_linea){
                primer_linea=false;

            }else{
                String[] registro = linea.split(separador);
                this.data.add(registro);
            }
        }
      lineas.close();
    }
    public ArrayList<String[]> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}

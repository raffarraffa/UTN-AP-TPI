package AP.JAVA.modelos;

import java.io.IOException;
import java.util.Map;

public interface DatosProde {
  void setDesdeCSV(String archivopath, String separador, boolean primer_linea) throws RuntimeException, IOException;
  void verData();
  Map getData();
}

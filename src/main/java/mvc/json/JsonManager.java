package mvc.json;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
public class JsonManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void guardar(String ruta, T objeto) {
        try (FileWriter escribir = new FileWriter((ruta))) {
            gson.toJson(objeto, escribir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T cargar(String ruta, Type tipo) {
        try (FileReader leer = new FileReader(ruta)) {
            return gson.fromJson(leer, tipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

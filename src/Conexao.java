import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexao {

    public static JsonObject getJson(String url) {

        try {
            // Verifica cache antes
            JsonObject cached = Cache.get(url);
            if (cached != null) {
                System.out.println("(cache) " + url);
                return cached;
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement element = JsonParser.parseString(response.body());
            JsonObject json = element.getAsJsonObject();

            // Armazena no cache
            Cache.put(url, json);

            return json;

        } catch (Exception e) {
            System.out.println("Erro ao conectar com API: " + e.getMessage());
            return null;
        }
    }
}

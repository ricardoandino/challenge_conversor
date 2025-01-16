import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class seleccionMoneda {

    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad){
        URI link = URI.create("https://v6.exchangerate-api.com/v6/5f154358412bd2740c6cc719/latest/"+monedaOrigen);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(link)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Parsear el json, es decir convertir el json a datos que el programa puede entender y manipular
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            //Obtener el objeto "Conversion_rates"
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

            //Obtener la moneda a la que deseamos convertir y pasarla a double
            double monedaConversion = conversionRates.get(monedaDestino).getAsDouble();

            //Hacer la conversion
            double conversion = cantidad*monedaConversion;

            DecimalFormat df = new DecimalFormat("#.000");
            double conversionRedondeada = Double.parseDouble(df.format(conversion).replace(",", ".")); // Reemplazar ',' por '.' si es necesario

            System.out.println("El resultado es: ");
            System.out.println(cantidad+" "+monedaOrigen+" es igual a: "+conversionRedondeada+" "+monedaDestino);

            return conversion;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

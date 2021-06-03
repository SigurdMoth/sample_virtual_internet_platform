package dk.vip.transmit;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import dk.vip.wrap.Wrap;

public class Transmission {
    /**
     * Must be used with a Wrap object that carries an expression and metabundles.
     * @param wrap
     * @param path
     * @return
     */
    public String transmit(Wrap wrap, String path) {
        Gson gson = new Gson();
        String stringWrap = gson.toJson(wrap);
        return transmit(stringWrap, path);
    }

    /**
     * Here Wrap is replaced with a String wrapped, primarily for proxies.
     * @param json
     * @param path
     * @return
     */
    public String transmit(String json, String path) {
        String[] result = new String[1];

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(path))
                .POST(BodyPublishers.ofString(json)).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(s -> result[0] = s)
                .join();

        return result[0];
    }
}

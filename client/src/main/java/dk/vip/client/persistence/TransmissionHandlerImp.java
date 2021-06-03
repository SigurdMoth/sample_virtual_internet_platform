package dk.vip.client.persistence;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Component;

import dk.vip.client.domain.transmit.ITransmissionHandler;

@Component
public class TransmissionHandlerImp implements ITransmissionHandler {

    @Override
    public String transmit(String expressionJson) {
        String[] result = new String[1];

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:42321/session/post"))
        .POST(BodyPublishers.ofString(expressionJson)).build();
        client.sendAsync(request, BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(s -> result[0] = s)
                .join();

        return result[0];
    }
}

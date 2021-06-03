package dk.vip.protocolbroker.presentation;

public interface IRouteHandler {
    String handleRoute(String requestBody);

	String publishProtocol(String request);
}

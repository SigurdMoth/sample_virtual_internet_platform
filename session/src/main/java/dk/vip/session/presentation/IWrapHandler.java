package dk.vip.session.presentation;

public interface IWrapHandler {
    void init();
    String handleClientWrap(String requestBody);
}

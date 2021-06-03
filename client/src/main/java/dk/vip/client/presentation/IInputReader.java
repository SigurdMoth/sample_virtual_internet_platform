package dk.vip.client.presentation;

public interface IInputReader {

    /**
     * Decides how the CLI starts reading input.
     */
    void start();
    /**
     * Decides how the CLI stops reading input.
     */
    void stop();
}

package dk.vip.client.presentation;

public interface IExpressionHandler {

    /**
     * handleExpression takes an input from the CLI and decides what to do with the
     * input. That is transform it into a usable function (expression), verifying
     * it, if a local/client command, it is run, else it is transmitted to the
     * session service/server.
     * 
     * @param query query is the value of the inputfield.
     * @return
     */
    String handleExpression(String query);
}

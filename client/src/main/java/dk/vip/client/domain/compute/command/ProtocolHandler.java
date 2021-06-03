package dk.vip.client.domain.compute.command;

import java.util.Map;
import dk.vip.expression.Expression;

public class ProtocolHandler {

    private final String protocol;
    private final Map<String, IExecuteExpression> commands;

    public ProtocolHandler(String protocol, Map<String, IExecuteExpression> commands) {
        this.protocol = protocol;
        this.commands = commands;
    }

    public String execute(Expression expression) {
        if (expression.getProtocol().equals(protocol)) {
            return commands.get(expression.getCommand()).execute(expression);
        }
        return "incorrect protocolhandler (ProtocolHandler.java)";
    }

    public String getProtocol() {
        return protocol;
    }

    public Map<String, IExecuteExpression> getCommands() {
        return commands;
    }

}

package dk.vip.expression;

import java.util.List;

public class Expression {
    private String protocol, command;
    private List<Parameter> parameters;

    public Expression(String protocol, String command, List<Parameter> parameters) {
        this.protocol = protocol;
        this.command = command;
        this.parameters = parameters;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getCommand() {
        return this.command;
    }

    public List<Parameter> getParameters() {
        return this.parameters;
    }
    public Parameter getParameterByIdentifier (String identifier){
        for (Parameter parameter : parameters) {
            if (parameter.getIdentifier().equals(identifier)){
                return parameter;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Protocol: %5s, Command: %5s", protocol, command));
        for (Parameter parameter : parameters) {
            sb.append(String.format("\n\t -%s", parameter));
        }
        return sb.toString();
    }
}

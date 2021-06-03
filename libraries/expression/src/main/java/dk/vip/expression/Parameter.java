package dk.vip.expression;

public class Parameter {
    private String identifier, value = "";
    private boolean hasValue;

    public Parameter(String identifier) {
        this.identifier = identifier;
    }

    public Parameter(String identifier, String value) {
        this.identifier = identifier;
        this.value = value;
        hasValue = true;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getValue() {
        return value;
    }

    public boolean hasValue() {
        return hasValue;
    }

    @Override
    public String toString() {
        return String.format("%s %s", identifier, value);
    }
}
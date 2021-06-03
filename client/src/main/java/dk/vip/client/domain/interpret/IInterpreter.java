package dk.vip.client.domain.interpret;

import dk.vip.expression.Expression;

public interface IInterpreter {
    /**
     * interpret handles how an input is changed into an expression format consisting of a command(set network) coupled with parameters (-x)
     */
    Expression interpret(String query);
}
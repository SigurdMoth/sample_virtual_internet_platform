package dk.vip.client.domain.compute.command;

import dk.vip.expression.Expression;

public interface IExecuteExpression {
    String execute(Expression expression);
}

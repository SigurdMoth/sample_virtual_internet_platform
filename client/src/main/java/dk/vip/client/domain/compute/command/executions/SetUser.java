package dk.vip.client.domain.compute.command.executions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dk.vip.client.domain.compute.command.IExecuteExpression;
import dk.vip.client.domain.compute.configuration.Configurator;
import dk.vip.client.domain.compute.configuration.models.UserConfiguration;
import dk.vip.expression.Expression;
import dk.vip.expression.Parameter;

@Service
public class SetUser implements IExecuteExpression {

    @Autowired
    private Configurator configurator;

    @Override
    public String execute(Expression expression) {
        UserConfiguration userConf = configurator.get(UserConfiguration.class);

        StringBuilder sb = new StringBuilder("UserConfiguration: ");
        
        Parameter parameter = expression.getParameterByIdentifier("n");
        if (parameter != null){
            userConf.setName(parameter.getValue());
            sb.append("\n \t+ added parameter " + parameter.getIdentifier() + " of value:" + parameter.getValue());
        }

        configurator.saveConfig(UserConfiguration.class);
        return sb.toString();
    }

}

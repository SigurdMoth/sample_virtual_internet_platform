package dk.vip.client.domain.compute.command.executions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dk.vip.client.domain.compute.command.IExecuteExpression;
import dk.vip.client.domain.compute.configuration.Configurator;
import dk.vip.client.domain.compute.configuration.models.NetworkConfiguration;
import dk.vip.expression.Expression;
import dk.vip.expression.Parameter;

@Service
public class SetDestination implements IExecuteExpression {

    @Autowired
    private Configurator configurator;

    // set network -v 6 -n 4
    @Override
    public String execute(Expression expression){
        NetworkConfiguration netConf = configurator.get(NetworkConfiguration.class);

        StringBuilder sb = new StringBuilder("NetworkConfiguration: ");

        Parameter parameter = expression.getParameterByIdentifier("v");
        if (parameter != null){
            netConf.setDestinationNetworkId(parameter.getValue());
            sb.append("\n \t+ added parameter " + parameter.getIdentifier() + " of value:" + parameter.getValue());
        }
        
        parameter = expression.getParameterByIdentifier("n");
        if (parameter != null){
            netConf.setDestinationNodeId(parameter.getValue());
            sb.append("\n \t+ added parameter " + parameter.getIdentifier() + " of value:" + parameter.getValue());
        }

        configurator.saveConfig(NetworkConfiguration.class);
        return sb.toString();
    }
}

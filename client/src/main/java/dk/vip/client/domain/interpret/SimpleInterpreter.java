package dk.vip.client.domain.interpret;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import dk.vip.expression.Expression;
import dk.vip.expression.Parameter;

/**
 * The simpleInterpreter is simple in nature as all it does is to split an input
 * into an expression consisting of a protocol, command and with belonging parameters (-x)
 */
@Component
public class SimpleInterpreter implements IInterpreter {
    private Logger logger = Logger.getLogger(SimpleInterpreter.class.getName());

    @Override
    public Expression interpret(String query) {
        List<Parameter> parameters = new ArrayList<>();

        String[] splitQuery = query.split(" ");
        String[] splitParameter = query.split(" -");
        // should be a thrown error that can be handled.
        for (int i = 1; i < splitParameter.length; i++) {
            String identifier = splitParameter[i].substring(0, 1);
            String value = splitParameter[i].substring(2);
            if (!splitParameter[i].substring(1, 2).equals(" ")) {
                logger.log(Level.WARNING, "A parameter was excluded because of a syntax error");
                continue; // skip add.
            }
            parameters.add(new Parameter(identifier, value));
        }

        // protocol, command, <List>parameters
        return new Expression(splitQuery[0], splitQuery[1], parameters);
    }
}

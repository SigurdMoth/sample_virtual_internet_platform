package dk.vip.protocols.http.domain.methods;

import java.util.logging.Level;

import dk.vip.expression.Expression;
import dk.vip.expression.Parameter;
import dk.vip.network.VipNode;
import dk.vip.network.VipProtocol;
import dk.vip.wrap.Wrap;

public class HttpPost extends HttpMethod {


    @Override
    public Wrap run(Wrap wrap, String jsonwrap) {
        //logger.log(Level.INFO, jsonwrap);
        VipNode destinationNode = Parser.fromJson(jsonwrap,
                "metaCollection.bundles.networkbundle.properties.destinationNode", VipNode.class);
        //logger.log(Level.INFO, destinationNode.toString());
        logger.log(Level.INFO, destinationNode.getProtocols().toString());
        VipProtocol protocol = destinationNode.getProtocols().get("http");
        if (protocol == null) {
            protocol = new VipProtocol("http");
            destinationNode.getProtocols().put("http", protocol);
        }

        Expression expression = wrap.getExpression();
        Parameter url = expression.getParameterByIdentifier("u");
        Parameter message = expression.getParameterByIdentifier("m");
        if (url != null && url.hasValue()) {
            if (message != null && message.hasValue()) {
                protocol.getProperties().put(url.getValue(), message.getValue());
            }
        }
        response = "200 OK";
        wrap.getMetaCollection().getBundles().get("networkbundle").put("destinationNode", destinationNode);
        wrap.getMetaCollection().add(bundle()); // response
        return wrap;
    }

}

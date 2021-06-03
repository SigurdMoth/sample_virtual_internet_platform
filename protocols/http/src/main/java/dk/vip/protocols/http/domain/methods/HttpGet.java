package dk.vip.protocols.http.domain.methods;

import dk.vip.expression.Expression;
import dk.vip.expression.Parameter;
import dk.vip.network.VipNode;
import dk.vip.network.VipProtocol;
import dk.vip.wrap.Wrap;

public class HttpGet extends HttpMethod {

    @Override
    public Wrap run(Wrap wrap, String jsonwrap) {

        VipNode destinationNode = Parser.fromJson(jsonwrap,
                "metaCollection.bundles.networkbundle.properties.destinationNode", VipNode.class);
        VipProtocol protocol = destinationNode.getProtocols().get("http");
        if (protocol == null) {
            protocol = new VipProtocol("http");
            destinationNode.getProtocols().put("http", protocol);
        }

        Expression expression = wrap.getExpression();
        Parameter url = expression.getParameterByIdentifier("u");
        if (url != null && url.hasValue()) {
            response = (String) protocol.getProperties().get(url.getValue());
            if (response == null){
                response = "404 Not Found";
            }
        } else{
            response = "400 Bad Request";
        }
        wrap.getMetaCollection().add(bundle());
        return wrap;
    }
}

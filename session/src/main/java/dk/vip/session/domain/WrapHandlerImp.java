package dk.vip.session.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import dk.vip.network.VipNetwork;
import dk.vip.network.VipNode;
import dk.vip.session.domain.transmit.ITransmissionHandler;
import dk.vip.session.presentation.IWrapHandler;
import dk.vip.wrap.MetaBundle;
import dk.vip.wrap.MetaCollection;
import dk.vip.wrap.Wrap;

@Component
public class WrapHandlerImp implements IWrapHandler {

    Logger logger = Logger.getLogger(WrapHandlerImp.class.getName());

    @Autowired
    ITransmissionHandler transmissionHandler;

    List<VipNetwork> networks;

    public void init() {
        // map network / load network
        VipNetwork vipNetwork1 = new VipNetwork(0);
        vipNetwork1.addNode(new VipNode(0, "198.168.1.2", "25::10", Arrays.asList(80, 8080, 443)));
        vipNetwork1.addNode(new VipNode(1, "198.168.1.3", "26::11", Arrays.asList(200, 614, 20)));
        VipNetwork vipNetwork2 = new VipNetwork(1);
        vipNetwork2.addNode(new VipNode(0, "198.168.1.4", "15::2", Arrays.asList(100, 314, 10)));
        vipNetwork2.addNode(new VipNode(1, "198.168.1.5", "16::4", Arrays.asList(200, 614, 20)));
        VipNetwork vipNetwork3 = new VipNetwork(5);
        vipNetwork3.addNode(new VipNode(0, "198.168.1.6", "36::3", Arrays.asList(100, 314, 10)));
        vipNetwork3.addNode(new VipNode(1, "198.168.1.7", "46::41", Arrays.asList(200, 614, 20)));
        VipNetwork vipNetwork4 = new VipNetwork(9);
        vipNetwork4.addNode(new VipNode(0, "198.168.1.8", "66::15", Arrays.asList(100, 314, 10)));
        vipNetwork4.addNode(new VipNode(1, "198.168.1.9", "77::16", Arrays.asList(200, 614, 20)));
        networks = new ArrayList<>();
        networks.add(vipNetwork1);
        networks.add(vipNetwork2);
        networks.add(vipNetwork3);
        networks.add(vipNetwork4);
    }

    public String handleClientWrap(String requestBody) {
        // Unwrap clientWrap
        Gson gson = new GsonBuilder().serializeNulls().create();
        Wrap clientWrap = null;
        try {
            clientWrap = gson.fromJson(requestBody, Wrap.class);
        } catch (JsonSyntaxException e) {
            logger.log(Level.WARNING, "Failed to unwrap Json wrapper", e);
        }
        // unwrap metabundle
        String jsonResponseWrap = null;
        if (clientWrap != null) {
            MetaCollection metaCollection = clientWrap.getMetaCollection();
            MetaBundle networkBundle = metaCollection.getBundles().get("networkbundle");
            String sourceNodeId = (String) networkBundle.getProperties().get("sourceNodeId");
            String sourceNetworkId = (String) networkBundle.getProperties().get("sourceNetworkId");
            String destinationNodeId = (String) networkBundle.getProperties().get("destinationNodeId");
            String destinationNetworkId = (String) networkBundle.getProperties().get("destinationNetworkId");
            networkBundle.put("sourceNode", findNode(sourceNodeId, sourceNetworkId));
            networkBundle.put("destinationNode", findNode(destinationNodeId, destinationNetworkId));

            // wrap && Redirect to protocolbroker
            jsonResponseWrap = transmissionHandler.handleTransmission(clientWrap,
                    "http://localhost:42322/protocolbroker/handleRoute");

            // Unwrap responseWrap from protocolbroker
            // unwrap metabundle
            logger.log(Level.INFO, jsonResponseWrap);
            JsonObject jsonObject = JsonParser.parseString(jsonResponseWrap).getAsJsonObject();
            JsonObject networkbundleJsonObject = jsonObject.get("metaCollection").getAsJsonObject().get("bundles")
                    .getAsJsonObject().get("networkbundle").getAsJsonObject().get("properties").getAsJsonObject();

            replaceNode(gson.fromJson(networkbundleJsonObject.get("sourceNode").toString(), VipNode.class),
                    Integer.parseInt(sourceNetworkId));
            replaceNode(gson.fromJson(networkbundleJsonObject.get("destinationNode").toString(), VipNode.class),
                    Integer.parseInt(destinationNetworkId));
        }
        return jsonResponseWrap;
    }

    private VipNode findNode(String node, String network) {
        VipNetwork foundNetwork = networks.stream().filter(n -> Integer.valueOf(network).equals(n.getId())).findAny()
                .orElse(null);
        if (foundNetwork != null) {
            return foundNetwork.getNode(Integer.valueOf(node));
        }
        return null;
    }

    private void replaceNode(VipNode vipNode, int networkId) {
        VipNetwork foundNetwork = networks.stream().filter(n -> networkId == n.getId()).findAny().orElse(null);
        if (foundNetwork != null) {
            foundNetwork.setNode(vipNode);
        }
    }
}

/**
 * List<Network>
 * 
 * 9 : Network { nodes : [ { "node" : "0", "network" : "9", "IP" :
 * "192.168.1.10", "MAC": "ABC::FFFF", ports : [ 443, 80, 8080 ] },{ "node" :
 * "1", "network" : "9", "IP" : "192.168.1.10", "MAC": "ABC::FFFF", ports : [
 * 443, 80, 8080 ] } ] }
 * 
 * 
 */
package dk.vip.client.domain.compute.configuration.models;

import dk.vip.client.domain.compute.configuration.ConfigurationModel;
import dk.vip.wrap.MetaBundle;

public class NetworkConfiguration extends ConfigurationModel {

    private String sourceNodeId, destinationNodeId;
    private String sourceNetworkId, destinationNetworkId;
    private String sourceNode;
    private String destinationNode;

    public String getSourceNode() {
        return this.sourceNode;
    }

    public void setSourceNode(String sourceNode) {
        this.sourceNode = sourceNode;
    }

    public String getDestinationNode() {
        return this.destinationNode;
    }

    public void setDestinationNode(String destinationNode) {
        this.destinationNode = destinationNode;
    }

    public String getSourceNodeId() {
        return this.sourceNodeId;
    }

    public void setSourceNodeId(String sourceNodeId) {
        this.sourceNodeId = sourceNodeId;
    }

    public String getDestinationNodeId() {
        return this.destinationNodeId;
    }

    public void setDestinationNodeId(String destinationNodeId) {
        this.destinationNodeId = destinationNodeId;
    }

    public String getSourceNetworkId() {
        return this.sourceNetworkId;
    }

    public void setSourceNetworkId(String sourceNetworkId) {
        this.sourceNetworkId = sourceNetworkId;
    }

    public String getDestinationNetworkId() {
        return this.destinationNetworkId;
    }

    public void setDestinationNetworkId(String destinationNetworkId) {
        this.destinationNetworkId = destinationNetworkId;
    }

    public NetworkConfiguration(String path) {
        super(path);
    }

    @Override
    public MetaBundle bundle() {
        MetaBundle metaBundle = new MetaBundle("networkbundle");
        metaBundle.put("sourceNodeId", getSourceNodeId());
        metaBundle.put("sourceNode", getSourceNode());
        metaBundle.put("sourceNetworkId", getSourceNetworkId());
        
        metaBundle.put("destinationNodeId", getDestinationNodeId());
        metaBundle.put("destinationNode", getDestinationNode());
        metaBundle.put("destinationNetworkId", getDestinationNetworkId());
        return metaBundle;
    }
}

package dk.vip.network;

import java.util.ArrayList;
import java.util.List;

public class VipNetwork {

    private final int id;
    private List<VipNode> nodes;

    public VipNetwork(int id) {
        this.id = id;
        nodes = new ArrayList<>();
    }

    public void addNode(VipNode vipNode) {
        nodes.add(vipNode);
    }

    public int getId() {
        return id;
    }

    public void setNode(VipNode vipNode) {
        nodes.set(vipNode.getId(), vipNode);
    }

    public VipNode getNode(int id) {
        return nodes.parallelStream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    public List<VipNode> getNodes() {
        return nodes;
    }
}

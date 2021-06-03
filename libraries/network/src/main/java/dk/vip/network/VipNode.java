package dk.vip.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VipNode {
    private final int id;
    private String ip, mac;
    private List<Integer> ports;
    private Map<String, VipProtocol> protocols;

    public VipNode(int id) {
        this.id = id;
        ports = new ArrayList<>();
        protocols = new HashMap<>();
        protocols.put("init", new VipProtocol("init"));
    }

    public VipNode(int id, String ip, String mac, List<Integer> ports) {
        this(id);
        this.ip = ip;
        this.mac = mac;
        this.ports = ports;
    }

    public int getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public List<Integer> getPorts() {
        return this.ports;
    }

    public void addPort(int port) {
        ports.add(port);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", ip='" + getIp() + "'" + ", mac='" + getMac() + "'" + ", ports='"
                + getPorts() + "'" + "}";
    }

    public void setPorts(List<Integer> ports) {
        this.ports = ports;
    }

    public Map<String, VipProtocol> getProtocols() {
        return this.protocols;
    }

    public void setProtocols(Map<String, VipProtocol> protocols) {
        this.protocols = protocols;
    }
}
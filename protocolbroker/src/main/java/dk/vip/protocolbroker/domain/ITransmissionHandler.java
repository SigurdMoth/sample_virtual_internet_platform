package dk.vip.protocolbroker.domain;

import dk.vip.wrap.Wrap;

public interface ITransmissionHandler {
    String handleTransmission(Wrap Wrap, String protocolServicePath);
}

package dk.vip.session.domain.transmit;

import dk.vip.wrap.Wrap;

public interface ITransmissionHandler {

    String handleTransmission(Wrap wrap, String protocolbrokerPath);
}

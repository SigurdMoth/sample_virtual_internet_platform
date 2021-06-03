package dk.vip.protocolbroker.persistence;

import org.springframework.stereotype.Service;
import dk.vip.protocolbroker.domain.ITransmissionHandler;
import dk.vip.transmit.Transmission;
import dk.vip.wrap.Wrap;

@Service
public class TransmissionHandlerImp implements ITransmissionHandler {

    @Override
    public String handleTransmission(Wrap wrap, String protocolServicePath) {
        Transmission transmission = new Transmission();
        return transmission.transmit(wrap, protocolServicePath);
    }

}

package dk.vip.session.persistence;

import org.springframework.stereotype.Service;

import dk.vip.session.domain.transmit.ITransmissionHandler;
import dk.vip.transmit.Transmission;
import dk.vip.wrap.Wrap;

@Service
public class TransmissionHandlerImp implements ITransmissionHandler {

    @Override
    public String handleTransmission(Wrap wrap, String protocolbrokerPath) {
        Transmission transmission = new Transmission();
        return transmission.transmit(wrap, protocolbrokerPath);
    }
}

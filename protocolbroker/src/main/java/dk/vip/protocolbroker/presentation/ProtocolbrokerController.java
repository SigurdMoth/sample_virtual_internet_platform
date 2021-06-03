package dk.vip.protocolbroker.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtocolbrokerController {

    @Autowired
    private IRouteHandler routeHandler;

    @PostMapping("/protocolbroker/handleRoute")
    public String handleRoute(@RequestBody String request) {
        return routeHandler.handleRoute(request);
    }

    /**
     * Receives a JSON string that can be converted to a metabundle
     */
    @PostMapping("/protocolbroker/publishProtocol")
    public String publishProtocol(@RequestBody String request) {
        return routeHandler.publishProtocol(request);
    }
}

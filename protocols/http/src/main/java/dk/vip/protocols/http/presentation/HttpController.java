package dk.vip.protocols.http.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
    Logger logger = Logger.getLogger(HttpController.class.getName());
    @Autowired
    IUnwrapper unwrapper;

    @PostMapping("/http")
    public String handleRoute(@RequestBody String request) {
        logger.log(Level.INFO, request);
        return unwrapper.handle(request);
    }
}

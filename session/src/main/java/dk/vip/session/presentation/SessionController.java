package dk.vip.session.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private IWrapHandler wrapHandler;

    @PostMapping("/session/post")
    public String receiveClientWrap(@RequestBody String request) {
        return wrapHandler.handleClientWrap(request);
    }

    @Autowired
    public void setStrategy(IWrapHandler wrapHandler) {
        this.wrapHandler = wrapHandler;
        wrapHandler.init();
    }
}

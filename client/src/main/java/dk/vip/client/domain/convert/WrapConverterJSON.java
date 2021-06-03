package dk.vip.client.domain.convert;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import dk.vip.wrap.Wrap;


@Component
public class WrapConverterJSON implements IWrapConverter {

    @Override
    public String convert(Wrap wrap) {
        Gson gson = new Gson();
        return gson.toJson(wrap);
    }

}

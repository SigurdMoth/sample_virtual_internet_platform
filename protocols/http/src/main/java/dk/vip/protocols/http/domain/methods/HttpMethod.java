package dk.vip.protocols.http.domain.methods;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dk.vip.wrap.Bundlable;
import dk.vip.wrap.MetaBundle;
import dk.vip.wrap.Wrap;

public abstract class HttpMethod implements Bundlable {

    protected String response;
    protected Logger logger = Logger.getLogger(HttpMethod.class.getName());

    public abstract Wrap run(Wrap wrap, String jsonwrap);

    public static class Parser {
        static Logger logger = Logger.getLogger(Parser.class.getName());
        public static <T extends Object> T fromJson(String json, String path, Class<T> clazz) {
            String[] pathArray = path.split("\\.");
            
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            for (String string : pathArray) {
                jsonObject = jsonObject.get(string).getAsJsonObject();
            }
            return new Gson().fromJson(jsonObject.toString(), clazz);
        }
    }

    @Override
    public MetaBundle bundle() {
        MetaBundle metaBundle = new MetaBundle("response");
        metaBundle.put("value", response);
        return metaBundle;
    }
}

package dk.vip.wrap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dk.vip.expression.Expression;

/**
 * A Wrap contains 2 parts. The expression, that is the commands that the
 * user wants to use on the server. And then the "MetaCollection" which is a
 * collection of meta data that is used to place the user the correct spot in
 * the internal VIP.
 */
public class Wrap {

    private final Expression expression;
    private final MetaCollection metaCollection;
    private String output;

    public Wrap(Expression expression, MetaCollection metaCollection) {
        this.expression = expression;
        this.metaCollection = metaCollection;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public MetaCollection getMetaCollection() {
        return this.metaCollection;
    }

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "{" +
            " expression='" + getExpression() + "'" +
            ", metaCollection='" + getMetaCollection() + "'" +
            ", output='" + getOutput() + "'" +
            "}";
    }

    public static class Parser {
        public static <T extends Object> T fromJson(String json, String path, Class<T> clazz) {
            String[] pathArray = path.split(".");
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            for (String string : pathArray) {
                jsonObject = jsonObject.get(string).getAsJsonObject();
            }
            return new Gson().fromJson(jsonObject.toString(), clazz);
        }
    }
}

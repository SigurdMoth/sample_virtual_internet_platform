package dk.vip.wrap;

import java.util.HashMap;
import java.util.Map;

public class MetaCollection {
    private final Map<String, MetaBundle> bundles;

    public MetaCollection() {
        bundles = new HashMap<>();
    }

    public void add(MetaBundle metaBundle){
        bundles.put(metaBundle.getName(), metaBundle);
    }
    public Map<String,MetaBundle> getBundles() {
        return this.bundles;
    }

    @Override
    public String toString() {
        return "{" +
            " bundles='" + getBundles() + "'" +
            "}";
    }

}

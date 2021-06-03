package dk.vip.protocolbroker.proxies;

import dk.vip.wrap.Bundlable;
import dk.vip.wrap.MetaBundle;

/**
 * When a service uses publish, it sends its name and IP/path/localhost etc. to
 * the protocolbroker.
 */
public abstract class ProtocolPublisher implements Bundlable {

    protected final String name;
    protected final String sourcePath;
    protected final String destinationPath;

    public ProtocolPublisher(String name, String sourcePath, String destinationPath) {
        this.name = name;
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
    }

    public abstract void publish();

    @Override
    public MetaBundle bundle() {
        MetaBundle metaBundle = new MetaBundle("protocol");
        metaBundle.put("name", name);
        metaBundle.put("sourcepath", sourcePath);
        metaBundle.put("destinationpath", destinationPath);
        return metaBundle;
    }
}

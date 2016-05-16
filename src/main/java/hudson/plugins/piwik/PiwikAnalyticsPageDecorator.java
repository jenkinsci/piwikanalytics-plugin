package hudson.plugins.piwik;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.Util;
import hudson.model.PageDecorator;
import net.sf.json.JSONObject;

@Extension
public class PiwikAnalyticsPageDecorator extends PageDecorator {

    public static final String PLUGIN_DISPLAY_NAME = "Piwik Analytics";
    private String siteId;
    private String piwikServer;
    private String piwikPath;
    private String additionnalDownloadExtensions;
    private boolean forceHttps = true;

    public PiwikAnalyticsPageDecorator() {
        super();
        load();
    }

    @DataBoundConstructor
    public PiwikAnalyticsPageDecorator(
            String siteId,
            String piwikServer,
            String piwikPath,
            String additionnalDEx,
            boolean forceHttps) {
        this();
        setSiteId(siteId);
        setPiwikServer(piwikServer);
        setPiwikPath(piwikPath);
        setAdditionnalDownloadExtensions(additionnalDEx);
        setForceHttps(forceHttps);
    }

    @Override
    public String getDisplayName() {
        return PLUGIN_DISPLAY_NAME;
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json)
            throws FormException {
        req.bindJSON(this, json);
        save();
        return true;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = Util.fixEmpty(siteId);
    }

    public String getPiwikServer() {
        return piwikServer;
    }

    public void setPiwikServer(String piwikServer) {
        this.piwikServer = PathHelper.fixPath(piwikServer);
    }

    public String getPiwikPath() {
        return piwikPath;
    }

    public void setPiwikPath(String piwikPath) {
        this.piwikPath = PathHelper.fixPath(piwikPath);
    }

    public String getAdditionnalDownloadExtensions() {
        return additionnalDownloadExtensions;
    }

    public void setAdditionnalDownloadExtensions(
            String additionnalDownloadExtensions) {
        this.additionnalDownloadExtensions = additionnalDownloadExtensions;
    }

    public boolean isForceHttps() {
        return forceHttps;
    }

    public void setForceHttps(boolean forceHttps) {
        this.forceHttps = forceHttps;
    }

    public String getProtocolString() {
        if( forceHttps ) {
            return "https://";
        } else {
            return "//";
        }
    }
}

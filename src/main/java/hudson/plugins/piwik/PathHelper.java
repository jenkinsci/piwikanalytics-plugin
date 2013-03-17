package hudson.plugins.piwik;

import hudson.Util;

/**
 * Created with IntelliJ IDEA.
 * User: cfurmaniak
 * Date: 17/03/13
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 */
public final class PathHelper {
    private PathHelper(){}

    public static final String fixPath(String input) {
        String fixedPath = Util.fixEmpty(input);
        if (fixedPath != null && !fixedPath.endsWith("/")) {
            fixedPath = fixedPath + "/";
        }
        return fixedPath;
    }
}

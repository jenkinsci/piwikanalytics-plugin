package hudson.plugins.piwik;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: cfurmaniak
 * Date: 17/03/13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public class TestPathHelper {

    public static final String VALID_INPUT_WITHOUT_SLASH = "http://www.jenkins-ci.org";
    public static final String VALID_INPUT_WITH_SLASH = "http://www.jenkins-ci.org/";

    @Test
    public void should_return_null_with_null_input() {
        String actual = PathHelper.fixPath(null);
        assertNull(actual);
    }

    @Test
    public void should_return_null_with_empty_input() {
        String actual = PathHelper.fixPath("");
        assertNull(actual);
    }

    @Test
    public void should_add_extra_slash() {
        String actual = PathHelper.fixPath(VALID_INPUT_WITHOUT_SLASH);
        assertEquals(VALID_INPUT_WITH_SLASH,actual);
    }

    @Test
    public void should_not_add_extra_slash() {
        String actual = PathHelper.fixPath(VALID_INPUT_WITH_SLASH);
        assertEquals(VALID_INPUT_WITH_SLASH,actual);
    }
}

import com.payrollsystem.jomariabejo.utils.iBooleanUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanUtilTest {
    @Test
    public void testIsFirstCharDoubleQuote() {
        assertTrue(iBooleanUtils.isFirstCharDoubleQuote("\"Hello"));
        assertFalse(iBooleanUtils.isFirstCharDoubleQuote("World"));
        assertFalse(iBooleanUtils.isFirstCharDoubleQuote(" "));
    }
    @Test
    public void testIsFirstCharWhitespace() {
        assertTrue(iBooleanUtils.isFirstCharWhitespace(" Hello"));
        assertFalse(iBooleanUtils.isFirstCharWhitespace("World"));
    }
}

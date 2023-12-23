import com.payrollsystem.jomariabejo.utils.DateChecker;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateCheckerTest {
    @Test
    public void DateStringTest() {
        assertTrue(DateChecker.isStringBirthday("November 28, 2001"));
        assertTrue(DateChecker.isStringBirthday("January 1, 2024"));
    }
}

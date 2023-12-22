import com.payrollsystem.jomariabejo.utils.MonthChecker;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MonthCheckerTest {
    @Test
    public void testMonthChecker() {
        assertFalse(MonthChecker.isStringContainsMonth("Hulyo"));
        assertTrue(MonthChecker.isStringContainsMonth("July 22"));
    }
}

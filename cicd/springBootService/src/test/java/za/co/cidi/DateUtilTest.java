package za.co.cidi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.cicd.util.DateUtil;

public class DateUtilTest {

    @Test
    public void testGetDayOfYearSuccess() {
        String dayOfYear = DateUtil.getDayOfYear();
        Assertions.assertNotNull(dayOfYear);
    }
}

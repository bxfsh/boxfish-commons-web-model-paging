package boxfish.commons.web.model.paging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PagingTest {

    @Test
    public void standard() {
        final PagingInfo actual = PagingInfo.standard();
        assertEquals(0, actual.getOffset());
        assertEquals(20, actual.getPageSize());
    }

    @Test
    public void limit_null() {
        final PagingInfo actual = PagingInfo.standard();
        assertNotNull(actual.getPageSize());
        actual.setPageSize(null);
        assertEquals(Integer.MAX_VALUE, actual.getPageSize());
    }

}

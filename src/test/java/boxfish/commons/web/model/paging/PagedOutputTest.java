package boxfish.commons.web.model.paging;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import boxfish.commons.web.model.paging.PagingInfo;
import boxfish.commons.web.model.paging.PagedOutput;

public class PagedOutputTest {

    @Test
    public void wrapper_helper() {
        final List<BigDecimal> entries = Arrays.asList(BigDecimal.ONE);

        final PagedOutput<?> wrapper1 = PagedOutput.wrap(entries);
        assertEquals(entries, wrapper1.getEntries());
        assertEquals(entries.size(), wrapper1.getTotalCount().intValue());
        assertNull(wrapper1.getOffset());
        assertNull(wrapper1.getLimit());

        final Integer limit = 10;
        final Long offset = 29341l;
        final Long totalCount = 9314824l;
        final PagedOutput<?> wrapper2 = PagedOutput.wrap(entries, PagingInfo.from(offset, limit), totalCount);
        assertEquals(entries, wrapper2.getEntries());
        assertEquals(totalCount, wrapper2.getTotalCount());
        assertEquals(offset, wrapper2.getOffset());
        assertEquals(limit, wrapper2.getLimit());
    }

    @Test
    public void wrapper_paging() {
        final PagedOutput<?> wrapper = new PagedOutput<>();

        final Integer limit = 11;
        wrapper.setLimit(limit);
        assertEquals(limit, wrapper.getLimit());

        final Long offset = 3948l;
        wrapper.setOffset(offset);
        assertEquals(offset, wrapper.getOffset());
    }

    @Test
    public void wrapper_mapRequest() {
        final PagedOutput<?> wrapper = new PagedOutput<>();

        final Map<String, Object> request = new HashMap<>();
        request.put("key", BigDecimal.valueOf(15));

        wrapper.setRequest(request);
        assertNotNull(wrapper.getRequest());
        assertEquals(request.size(), wrapper.getRequest().size());
        assertEquals(request.get("key"), wrapper.getRequest().get("key"));
    }

    @Test
    public void wrapper_get() {
        final Integer item = Integer.valueOf(1);
        final List<Integer> list = asList(item);
        final PagedOutput<Integer> wrapper = PagedOutput.wrap(list);
        assertEquals(item, wrapper.getEntries().get(0));
        assertEquals(item, wrapper.get(0));
    }

}

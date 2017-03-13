package boxfish.commons.web.model.paging;

import java.util.List;
import java.util.Map;

public class PagedOutput<TEntry> {
    private final PagingInfo paging = PagingInfo.standard();
    private List<TEntry> entries;
    private Map<String, ?> request;
    private Long totalCount;

    public static <TEntry> PagedOutput<TEntry> wrap(final List<TEntry> entries) {
        return new PagedOutput<TEntry>()
            .setEntries(entries)
            .setTotalCount(entries != null ? Long.valueOf(entries.size()) : null)
            .setOffset(null)
            .setLimit(null);
    }

    public static <TEntry> PagedOutput<TEntry> wrap(
            final List<TEntry> entries,
            final PagingInfo paging,
            final Long totalCount) {

        if (paging == null)
            throw new IllegalArgumentException("paging");

        return new PagedOutput<TEntry>()
            .setEntries(entries)
            .setTotalCount(totalCount)
            .setOffset(Long.valueOf(paging.getOffset()))
            .setLimit(paging.getPageSize());
    }

    public Map<String, ?> getRequest() {
        return request;
    }

    public PagedOutput<TEntry> setRequest(final Map<String, ?> request) {
        this.request = request;
        return this;
    }

    public Long getOffset() {
        return Long.valueOf(paging.getOffset());
    }

    public PagedOutput<TEntry> setOffset(final Long offset) {
        this.paging.setOffset(offset);
        return this;
    }

    public Integer getLimit() {
        return paging.getPageSize();
    }

    public PagedOutput<TEntry> setLimit(final Integer limit) {
        this.paging.setPageSize(limit);
        return this;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public PagedOutput<TEntry> setTotalCount(final Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public List<TEntry> getEntries() {
        return entries;
    }

    public PagedOutput<TEntry> setEntries(final List<TEntry> entries) {
        this.entries = entries;
        return this;
    }

    public TEntry get(final Integer index) {
        if (this.entries != null)
            return this.entries.get(index);
        return null;
    }
}

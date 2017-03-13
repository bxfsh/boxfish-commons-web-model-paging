package boxfish.commons.web.model.paging;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import boxfish.commons.web.model.Model;

public class PagingInfo implements Pageable {
    public static PagingInfo standard() {
        return new PagingInfo(null, 20);
    }

    public static PagingInfo from(Long offset, Integer limit) {
        return new PagingInfo(offset, limit);
    }

    public static PagingInfo from(final Model query) {
        notNull(query, "'query' must not be null");
        return new PagingInfo(
            query.hasNonBlank("offset") ? query.get("offset").asLong() : null,
            query.hasNonBlank("limit") ? query.get("limit").asInteger() : null);
    }

    private Integer limit;
    private Long offset;

    public PagingInfo(final Long offset, final Integer limit) {
        isTrue(offset == null || offset >= 0, "'offset' must not be less than zero!");
        isTrue(limit == null || limit >= 0, "'limit' must not be less than zero!");
        this.limit = limit;
        this.offset = offset;
    }

    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        if (limit != null)
            return limit.intValue();
        else
            return Integer.MAX_VALUE;
    }

    public PagingInfo setPageSize(final Integer limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public int getOffset() {
        if (offset != null)
            return offset.intValue();
        else
            return 0;
    }

    public PagingInfo setOffset(final Long offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return this;
    }

    @Override
    public Pageable first() {
        return this;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

}

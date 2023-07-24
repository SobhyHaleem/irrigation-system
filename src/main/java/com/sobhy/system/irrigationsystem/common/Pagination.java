package com.sobhy.system.irrigationsystem.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * pagination class
 */

public class Pagination {

    /**
     * total count property
     */
    @Getter
    @Setter
    private long total = 0;
    /**
     * total count property
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String,Object> properties;
    /**
     * page size property
     */
    @Getter
    @Setter
    private int pageSize = 5;
    /**
     * page number property
     */
    @Getter
    @Setter
    private int pageNum = 0;

    /**
     * pagination constructor
     */

    public Pagination() {
        super();
    }

    /**
     * pagination constructor
     */

    public Pagination(final int pageSize, final int pageNum) {
        super();
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    /**
     * pagination constructor
     */

    public Pagination(final long total, final int pageSize, final int pageNum) {
        super();
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
    public Pagination( final int pageSize, final int pageNum, final Map<String,Object> properties) {
        super();
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.properties= properties;
    }

}

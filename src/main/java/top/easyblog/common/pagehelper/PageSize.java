package top.easyblog.common.pagehelper;

/**
 * PageHelper——分页的大小
 *
 * @author huangxin
 */
public enum PageSize {
    /**
     * 最小的页面大小
     */
    MIN_PAGE_SIZE(10),

    /**
     * 默认的页面大小
     */
    DEFAULT_PAGE_SIZE(15),

    /**
     * 最大的页面大小
     */
    MAX_PAGE_SIZE(20);

    private final int pageSize;

    PageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

}

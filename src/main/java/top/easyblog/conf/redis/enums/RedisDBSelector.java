package top.easyblog.conf.redis.enums;

/**
 * @author ：huangxin
 * @modified ：
 * @since ：2020/06/11 10:25
 */

public enum RedisDBSelector {
    /**
     * redis的默认16个数据库
     */
    DB_0(0), DB_1(1), DB_2(2), DB_3(3), DB_4(4), DB_5(5), DB_6(6), DB_7(7),
    DB_8(8), DB_9(9), DB_10(10), DB_11(11), DB_12(12), DB_13(13), DB_14(14), DB_15(15);


    private final int db;

    RedisDBSelector(int db) {
        this.db = db;
    }

    public int getDb() {
        return db;
    }

}

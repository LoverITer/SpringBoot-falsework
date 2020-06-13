package top.easyblog.conf.redis;

import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;

import java.util.Objects;

/**
 * 布隆过滤器帮助类
 *
 * @param <T>
 * @author Huangxin
 */
public class BloomFilterHelper<T> {

    private int numHashFunctions;

    private int bitSize;

    private Funnel<T> funnel;

    public BloomFilterHelper(Funnel<T> funnel, int expectedInsertions, double fpp) {
        Objects.requireNonNull(funnel, "Funnel<T> funnel不能为空！");
        this.funnel = funnel;
        bitSize = optimalNumOfBits(expectedInsertions, fpp);
        numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, bitSize);
    }

    /**
     * 根据目标要插入的数据大小expectedInsertions，计算合适的bit数组的长度
     */
    private int optimalNumOfBits(long n, double p) {
        if (p == 0) {
            throw new IllegalArgumentException("illegal parameter: p" + p);
        }
        return (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }

    /**
     * 根据目标要插入的数据大小expectedInsertions，计算合适的hash函数的个数
     */
    private int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    /**
     * hash
     *
     * @param value 关键字
     * @return
     */
    public int[] murmurHashOffset(T value) {
        int[] offset = new int[numHashFunctions];

        long hash64 = Hashing.murmur3_128().hashObject(value, funnel).asLong();
        int hash1 = (int) hash64;
        int hash2 = (int) (hash64 >>> 32);
        for (int i = 1; i <= numHashFunctions; i++) {
            int nextHash = hash1 + i * hash2;
            if (nextHash < 0) {
                nextHash = ~nextHash;
            }
            offset[i - 1] = nextHash % bitSize;
        }

        return offset;
    }
}
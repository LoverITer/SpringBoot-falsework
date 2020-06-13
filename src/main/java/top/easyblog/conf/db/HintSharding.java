package top.easyblog.conf.db;

/**
 * 分库分表规则配置（算法）,在配置文件中配置此实现类
 *
 * @author huangxin
 * @version 1.0
 * @date 2019-09-19 19:25
 */
/*
public class HintSharding implements HintShardingAlgorithm<Integer> {

    */
/**
     * @param availableTargetNames 分片表名的集合
     * @param hintShardingValue    分片键集合
     * @return java.util.Collection<java.lang.String>
     * @date 2019-09-22 12:23
     *//*

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Integer> hintShardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : availableTargetNames) {
            for (Integer value : hintShardingValue.getValues()) {
                if (each.endsWith(String.valueOf(value % 2))) {
                    System.out.println("*********************");
                    result.add(each);
                }
            }
        }
        return result;
    }
}
*/

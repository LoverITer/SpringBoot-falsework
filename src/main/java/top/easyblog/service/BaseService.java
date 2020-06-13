package top.easyblog.service;

/**
 * 基础性的查询服务接口
* @ClassName: BaseService
 * @Description:
 * @author Huangxin
*
 */
public interface BaseService<T> {

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 增加一条数据
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    T selectByPrimaryKey(String id);

    /**
     * 更据主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

}

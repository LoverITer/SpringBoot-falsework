package top.easyblog.service;

import top.easyblog.entity.User;

/**
 * @author ：huangxin
 * @modified ：
 * @since ：2020/06/12 20:57
 */
public interface IUserService<T> extends BaseService<T> {

    /**
     * 通过主键查询用户
     * @param id
     * @return
     */
    User getUserById(int id);
}

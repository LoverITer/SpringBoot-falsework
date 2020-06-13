package top.easyblog.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.easyblog.conf.redis.enums.RedisDBSelector;
import top.easyblog.entity.User;
import top.easyblog.mapper.UserMapper;
import top.easyblog.service.IUserService;
import top.easyblog.util.RedisUtils;

/**
 * @author ：huangxin
 * @modified ：
 * @since ：2020/06/10 19:21
 */
@Service
public class UserServiceImpl implements IUserService<User> {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtils redisUtils;


    /**
     * 根据Id获取用户数据
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        //Redis中尝试获取
        String infoStr = (String) redisUtils.hget("USER_INFO", id + "", RedisDBSelector.DB_0);
        User user = JSONObject.parseObject(infoStr, User.class);
        if (user == null) {
            //发现没有再从数据库中查询
            user = userMapper.selectByPrimaryKey(id);
            redisUtils.hset("USER_INFO", id + "", JSONObject.toJSONString(user), 60 * 60, RedisDBSelector.DB_0);
        }
        return user;
    }


    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return null;
    }


    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

}

package top.easyblog.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.easyblog.entity.User;

import java.util.List;

/**
 * @author Huangxin
 */
@Repository
public interface UserMapper {

    int insertBatch(@Param("users") List<User> user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

}
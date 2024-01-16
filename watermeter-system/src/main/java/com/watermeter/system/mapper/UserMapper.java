package com.watermeter.system.mapper;

import java.util.List;
import com.watermeter.system.domain.User;

/**
 * 用户信息管理Mapper接口
 * 
 * @author Patrick
 * @date 2023-04-05
 */
public interface UserMapper 
{
    /**
     * 查询用户信息管理
     * 
     * @param id 用户信息管理主键
     * @return 用户信息管理
     */
    public User selectUserById(Long id);

    /**
     * 查询用户信息管理列表
     * 
     * @param user 用户信息管理
     * @return 用户信息管理集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户信息管理
     * 
     * @param user 用户信息管理
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户信息管理
     * 
     * @param user 用户信息管理
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户信息管理
     * 
     * @param id 用户信息管理主键
     * @return 结果
     */
    public int deleteUserById(Long id);

    /**
     * 批量删除用户信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByIds(String[] ids);
}

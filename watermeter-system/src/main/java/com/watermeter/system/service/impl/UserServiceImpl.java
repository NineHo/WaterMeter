package com.watermeter.system.service.impl;

import java.util.List;
import com.watermeter.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.watermeter.system.mapper.UserMapper;
import com.watermeter.system.domain.User;
import com.watermeter.system.service.IUserService;
import com.watermeter.common.core.text.Convert;

/**
 * 用户信息管理Service业务层处理
 * 
 * @author Patrick
 * @date 2023-04-05
 */
@Service
public class UserServiceImpl implements IUserService 
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户信息管理
     * 
     * @param id 用户信息管理主键
     * @return 用户信息管理
     */
    @Override
    public User selectUserById(Long id)
    {
        return userMapper.selectUserById(id);
    }

    /**
     * 查询用户信息管理列表
     * 
     * @param user 用户信息管理
     * @return 用户信息管理
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户信息管理
     * 
     * @param user 用户信息管理
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        user.setCreateTime(DateUtils.getNowDate());
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户信息管理
     * 
     * @param user 用户信息管理
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除用户信息管理
     * 
     * @param ids 需要删除的用户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteUserByIds(String ids)
    {
        return userMapper.deleteUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息管理信息
     * 
     * @param id 用户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteUserById(Long id)
    {
        return userMapper.deleteUserById(id);
    }
}

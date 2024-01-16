package com.watermeter.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.watermeter.common.annotation.Excel;
import com.watermeter.common.core.domain.BaseEntity;

/**
 * 用户信息管理对象 user
 * 
 * @author Patrick
 * @date 2023-04-05
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long id;

    /** 水表 */
    @Excel(name = "水表")
    private Long meterId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMeterId(Long meterId) 
    {
        this.meterId = meterId;
    }

    public Long getMeterId() 
    {
        return meterId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("meterId", getMeterId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("createTime", getCreateTime())
            .append("username", getUsername())
            .append("password", getPassword())
            .toString();
    }
}

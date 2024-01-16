package com.watermeter.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.watermeter.common.annotation.Excel;
import com.watermeter.common.core.domain.BaseEntity;

/**
 * 告警联系人对象 sys_area_connector
 * 
 * @author patrick
 * @date 2023-04-18
 */
public class SysAreaConnector extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 负责区域 */
    @Excel(name = "负责区域")
    private String area;

    /** 电话号 */
    @Excel(name = "电话号")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("area", getArea())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("createTime", getCreateTime())
            .toString();
    }
}

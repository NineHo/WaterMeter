package com.watermeter.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.watermeter.common.annotation.Excel;
import com.watermeter.common.core.domain.BaseEntity;

/**
 * 告警记录对象 sys_meter_alarm
 * 
 * @author Patrick
 * @date 2023-04-18
 */
public class SysMeterAlarm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 水表ID */
    @Excel(name = "水表ID")
    private Long meterId;

    /** 联系人 */
    @Excel(name = "联系人")
    private String connector;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

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
    public void setConnector(String connector) 
    {
        this.connector = connector;
    }

    public String getConnector() 
    {
        return connector;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("meterId", getMeterId())
            .append("connector", getConnector())
            .append("status", getStatus())
            .toString();
    }
}

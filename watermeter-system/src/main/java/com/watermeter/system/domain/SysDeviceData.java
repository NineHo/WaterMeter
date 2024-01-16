package com.watermeter.system.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.watermeter.common.annotation.Excel;
import com.watermeter.common.core.domain.BaseEntity;

/**
 * 设备数据对象 sys_device_data
 * 
 * @author Patrick
 * @date 2023-05-24
 */
@TableName("sys_device_data")
public class SysDeviceData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 水表ID */
    @Excel(name = "水表ID")
    private Long deviceId;

    /** 水流量 */
    @Excel(name = "水流量")
    private BigDecimal dataValue;

    /** 接收时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接收时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime dateTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId()
    {
        return deviceId;
    }
    public void setDataValue(BigDecimal dataValue) 
    {
        this.dataValue = dataValue;
    }

    public BigDecimal getDataValue() 
    {
        return dataValue;
    }
    public void setDateTime(LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("dataValue", getDataValue())
            .append("dateTime", getDateTime())
            .toString();
    }
}

package com.watermeter.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.watermeter.common.annotation.Excel;
import com.watermeter.common.core.domain.BaseEntity;

/**
 * 水表信息管理对象 sys_meter_info
 * 
 * @author Patrick
 * @date 2023-05-24
 */
public class SysMeterInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private Long userId;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private String meterAddress;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailAddress;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 设备数据信息 */
    private List<SysDeviceData> sysDeviceDataList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setMeterAddress(String meterAddress) 
    {
        this.meterAddress = meterAddress;
    }

    public String getMeterAddress() 
    {
        return meterAddress;
    }
    public void setDetailAddress(String detailAddress) 
    {
        this.detailAddress = detailAddress;
    }

    public String getDetailAddress() 
    {
        return detailAddress;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public List<SysDeviceData> getSysDeviceDataList()
    {
        return sysDeviceDataList;
    }

    public void setSysDeviceDataList(List<SysDeviceData> sysDeviceDataList)
    {
        this.sysDeviceDataList = sysDeviceDataList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("meterAddress", getMeterAddress())
            .append("detailAddress", getDetailAddress())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .append("sysDeviceDataList", getSysDeviceDataList())
            .toString();
    }
}

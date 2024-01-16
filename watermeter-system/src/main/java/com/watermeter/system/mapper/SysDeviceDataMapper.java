package com.watermeter.system.mapper;

import com.watermeter.system.domain.SysDeviceData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author dick1
* @description 针对表【sys_device_data(设备数据)】的数据库操作Mapper
* @createDate 2023-05-24 09:10:12
* @Entity com.watermeter.system.domain.SysDeviceData
*/
public interface SysDeviceDataMapper extends BaseMapper<SysDeviceData> {
    @Select("SELECT * FROM sys_device_data WHERE device_id = 2101632676")
    List<SysDeviceData> findById();
    @Select("SELECT * FROM sys_device_data WHERE data_value > 0.3 OR data_value < 0.01")
    List<SysDeviceData> findByValue();
    @Select("SELECT COUNT(*) FROM sys_meter_alarm")
    int getCount();
    @Select("SELECT COUNT(*) FROM sys_meter_info WHERE status = 0")
    int getMeterNumber();

}





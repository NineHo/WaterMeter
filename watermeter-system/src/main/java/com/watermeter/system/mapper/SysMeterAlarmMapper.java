package com.watermeter.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.watermeter.system.domain.SysMeterAlarm;

/**
 * 告警记录Mapper接口
 * 
 * @author Patrick
 * @date 2023-04-18
 */
public interface SysMeterAlarmMapper extends BaseMapper<SysMeterAlarm>
{
    /**
     * 查询告警记录
     * 
     * @param id 告警记录主键
     * @return 告警记录
     */
    public SysMeterAlarm selectSysMeterAlarmById(Long id);

    /**
     * 查询告警记录列表
     * 
     * @param sysMeterAlarm 告警记录
     * @return 告警记录集合
     */
    public List<SysMeterAlarm> selectSysMeterAlarmList(SysMeterAlarm sysMeterAlarm);

    /**
     * 新增告警记录
     * 
     * @param sysMeterAlarm 告警记录
     * @return 结果
     */
    public int insertSysMeterAlarm(SysMeterAlarm sysMeterAlarm);

    /**
     * 修改告警记录
     * 
     * @param sysMeterAlarm 告警记录
     * @return 结果
     */
    public int updateSysMeterAlarm(SysMeterAlarm sysMeterAlarm);

    /**
     * 删除告警记录
     * 
     * @param id 告警记录主键
     * @return 结果
     */
    public int deleteSysMeterAlarmById(Long id);

    /**
     * 批量删除告警记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMeterAlarmByIds(String[] ids);
}

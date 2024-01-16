package com.watermeter.system.service.impl;

import java.util.List;
import com.watermeter.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.watermeter.system.mapper.SysMeterAlarmMapper;
import com.watermeter.system.domain.SysMeterAlarm;
import com.watermeter.system.service.ISysMeterAlarmService;
import com.watermeter.common.core.text.Convert;

/**
 * 告警记录Service业务层处理
 * 
 * @author Patrick
 * @date 2023-04-18
 */
@Service
public class SysMeterAlarmServiceImpl implements ISysMeterAlarmService 
{
    @Autowired
    private SysMeterAlarmMapper sysMeterAlarmMapper;

    /**
     * 查询告警记录
     * 
     * @param id 告警记录主键
     * @return 告警记录
     */
    @Override
    public SysMeterAlarm selectSysMeterAlarmById(Long id)
    {
        return sysMeterAlarmMapper.selectSysMeterAlarmById(id);
    }

    /**
     * 查询告警记录列表
     * 
     * @param sysMeterAlarm 告警记录
     * @return 告警记录
     */
    @Override
    public List<SysMeterAlarm> selectSysMeterAlarmList(SysMeterAlarm sysMeterAlarm)
    {
        return sysMeterAlarmMapper.selectSysMeterAlarmList(sysMeterAlarm);
    }

    /**
     * 新增告警记录
     * 
     * @param sysMeterAlarm 告警记录
     * @return 结果
     */
    @Override
    public int insertSysMeterAlarm(SysMeterAlarm sysMeterAlarm)
    {
        sysMeterAlarm.setCreateTime(DateUtils.getNowDate());
        return sysMeterAlarmMapper.insertSysMeterAlarm(sysMeterAlarm);
    }

    /**
     * 修改告警记录
     * 
     * @param sysMeterAlarm 告警记录
     * @return 结果
     */
    @Override
    public int updateSysMeterAlarm(SysMeterAlarm sysMeterAlarm)
    {
        return sysMeterAlarmMapper.updateSysMeterAlarm(sysMeterAlarm);
    }

    /**
     * 批量删除告警记录
     * 
     * @param ids 需要删除的告警记录主键
     * @return 结果
     */
    @Override
    public int deleteSysMeterAlarmByIds(String ids)
    {
        return sysMeterAlarmMapper.deleteSysMeterAlarmByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除告警记录信息
     * 
     * @param id 告警记录主键
     * @return 结果
     */
    @Override
    public int deleteSysMeterAlarmById(Long id)
    {
        return sysMeterAlarmMapper.deleteSysMeterAlarmById(id);
    }
}

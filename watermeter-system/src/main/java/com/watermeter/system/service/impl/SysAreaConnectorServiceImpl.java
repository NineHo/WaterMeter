package com.watermeter.system.service.impl;

import java.util.List;
import com.watermeter.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.watermeter.system.mapper.SysAreaConnectorMapper;
import com.watermeter.system.domain.SysAreaConnector;
import com.watermeter.system.service.ISysAreaConnectorService;
import com.watermeter.common.core.text.Convert;

/**
 * 告警联系人Service业务层处理
 * 
 * @author patrick
 * @date 2023-04-18
 */
@Service
public class SysAreaConnectorServiceImpl implements ISysAreaConnectorService 
{
    @Autowired
    private SysAreaConnectorMapper sysAreaConnectorMapper;

    /**
     * 查询告警联系人
     * 
     * @param id 告警联系人主键
     * @return 告警联系人
     */
    @Override
    public SysAreaConnector selectSysAreaConnectorById(Long id)
    {
        return sysAreaConnectorMapper.selectSysAreaConnectorById(id);
    }

    /**
     * 查询告警联系人列表
     * 
     * @param sysAreaConnector 告警联系人
     * @return 告警联系人
     */
    @Override
    public List<SysAreaConnector> selectSysAreaConnectorList(SysAreaConnector sysAreaConnector)
    {
        return sysAreaConnectorMapper.selectSysAreaConnectorList(sysAreaConnector);
    }

    /**
     * 新增告警联系人
     * 
     * @param sysAreaConnector 告警联系人
     * @return 结果
     */
    @Override
    public int insertSysAreaConnector(SysAreaConnector sysAreaConnector)
    {
        sysAreaConnector.setCreateTime(DateUtils.getNowDate());
        return sysAreaConnectorMapper.insertSysAreaConnector(sysAreaConnector);
    }

    /**
     * 修改告警联系人
     * 
     * @param sysAreaConnector 告警联系人
     * @return 结果
     */
    @Override
    public int updateSysAreaConnector(SysAreaConnector sysAreaConnector)
    {
        return sysAreaConnectorMapper.updateSysAreaConnector(sysAreaConnector);
    }

    /**
     * 批量删除告警联系人
     * 
     * @param ids 需要删除的告警联系人主键
     * @return 结果
     */
    @Override
    public int deleteSysAreaConnectorByIds(String ids)
    {
        return sysAreaConnectorMapper.deleteSysAreaConnectorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除告警联系人信息
     * 
     * @param id 告警联系人主键
     * @return 结果
     */
    @Override
    public int deleteSysAreaConnectorById(Long id)
    {
        return sysAreaConnectorMapper.deleteSysAreaConnectorById(id);
    }
}

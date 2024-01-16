package com.watermeter.system.service;

import java.util.List;
import com.watermeter.system.domain.SysAreaConnector;

/**
 * 告警联系人Service接口
 * 
 * @author patrick
 * @date 2023-04-18
 */
public interface ISysAreaConnectorService 
{
    /**
     * 查询告警联系人
     * 
     * @param id 告警联系人主键
     * @return 告警联系人
     */
    public SysAreaConnector selectSysAreaConnectorById(Long id);

    /**
     * 查询告警联系人列表
     * 
     * @param sysAreaConnector 告警联系人
     * @return 告警联系人集合
     */
    public List<SysAreaConnector> selectSysAreaConnectorList(SysAreaConnector sysAreaConnector);

    /**
     * 新增告警联系人
     * 
     * @param sysAreaConnector 告警联系人
     * @return 结果
     */
    public int insertSysAreaConnector(SysAreaConnector sysAreaConnector);

    /**
     * 修改告警联系人
     * 
     * @param sysAreaConnector 告警联系人
     * @return 结果
     */
    public int updateSysAreaConnector(SysAreaConnector sysAreaConnector);

    /**
     * 批量删除告警联系人
     * 
     * @param ids 需要删除的告警联系人主键集合
     * @return 结果
     */
    public int deleteSysAreaConnectorByIds(String ids);

    /**
     * 删除告警联系人信息
     * 
     * @param id 告警联系人主键
     * @return 结果
     */
    public int deleteSysAreaConnectorById(Long id);
}

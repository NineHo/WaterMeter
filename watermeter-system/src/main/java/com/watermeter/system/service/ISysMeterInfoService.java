package com.watermeter.system.service;

import java.util.List;
import com.watermeter.system.domain.SysMeterInfo;

/**
 * 水表信息管理Service接口
 * 
 * @author Patrick
 * @date 2023-05-24
 */
public interface ISysMeterInfoService 
{
    /**
     * 查询水表信息管理
     * 
     * @param id 水表信息管理主键
     * @return 水表信息管理
     */
    public SysMeterInfo selectSysMeterInfoById(Long id);

    /**
     * 查询水表信息管理列表
     * 
     * @param sysMeterInfo 水表信息管理
     * @return 水表信息管理集合
     */
    public List<SysMeterInfo> selectSysMeterInfoList(SysMeterInfo sysMeterInfo);

    /**
     * 新增水表信息管理
     * 
     * @param sysMeterInfo 水表信息管理
     * @return 结果
     */
    public int insertSysMeterInfo(SysMeterInfo sysMeterInfo);

    /**
     * 修改水表信息管理
     * 
     * @param sysMeterInfo 水表信息管理
     * @return 结果
     */
    public int updateSysMeterInfo(SysMeterInfo sysMeterInfo);

    /**
     * 批量删除水表信息管理
     * 
     * @param ids 需要删除的水表信息管理主键集合
     * @return 结果
     */
    public int deleteSysMeterInfoByIds(String ids);

    /**
     * 删除水表信息管理信息
     * 
     * @param id 水表信息管理主键
     * @return 结果
     */
    public int deleteSysMeterInfoById(Long id);
}

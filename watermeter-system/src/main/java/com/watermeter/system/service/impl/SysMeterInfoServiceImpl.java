package com.watermeter.system.service.impl;

import java.util.List;
import com.watermeter.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.watermeter.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.watermeter.system.domain.SysDeviceData;
import com.watermeter.system.mapper.SysMeterInfoMapper;
import com.watermeter.system.domain.SysMeterInfo;
import com.watermeter.system.service.ISysMeterInfoService;
import com.watermeter.common.core.text.Convert;

/**
 * 水表信息管理Service业务层处理
 * 
 * @author Patrick
 * @date 2023-05-24
 */
@Service
public class SysMeterInfoServiceImpl implements ISysMeterInfoService 
{
    @Autowired
    private SysMeterInfoMapper sysMeterInfoMapper;

    /**
     * 查询水表信息管理
     * 
     * @param id 水表信息管理主键
     * @return 水表信息管理
     */
    @Override
    public SysMeterInfo selectSysMeterInfoById(Long id)
    {
        return sysMeterInfoMapper.selectSysMeterInfoById(id);
    }

    /**
     * 查询水表信息管理列表
     * 
     * @param sysMeterInfo 水表信息管理
     * @return 水表信息管理
     */
    @Override
    public List<SysMeterInfo> selectSysMeterInfoList(SysMeterInfo sysMeterInfo)
    {
        return sysMeterInfoMapper.selectSysMeterInfoList(sysMeterInfo);
    }

    /**
     * 新增水表信息管理
     * 
     * @param sysMeterInfo 水表信息管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysMeterInfo(SysMeterInfo sysMeterInfo)
    {
        int rows = sysMeterInfoMapper.insertSysMeterInfo(sysMeterInfo);
        insertSysDeviceData(sysMeterInfo);
        return rows;
    }

    /**
     * 修改水表信息管理
     * 
     * @param sysMeterInfo 水表信息管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSysMeterInfo(SysMeterInfo sysMeterInfo)
    {
        sysMeterInfo.setUpdateTime(DateUtils.getNowDate());
        sysMeterInfoMapper.deleteSysDeviceDataByDeviceId(sysMeterInfo.getId());
        insertSysDeviceData(sysMeterInfo);
        return sysMeterInfoMapper.updateSysMeterInfo(sysMeterInfo);
    }

    /**
     * 批量删除水表信息管理
     * 
     * @param ids 需要删除的水表信息管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysMeterInfoByIds(String ids)
    {
        sysMeterInfoMapper.deleteSysDeviceDataByDeviceIds(Convert.toStrArray(ids));
        return sysMeterInfoMapper.deleteSysMeterInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除水表信息管理信息
     * 
     * @param id 水表信息管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysMeterInfoById(Long id)
    {
        sysMeterInfoMapper.deleteSysDeviceDataByDeviceId(id);
        return sysMeterInfoMapper.deleteSysMeterInfoById(id);
    }

    /**
     * 新增设备数据信息
     * 
     * @param sysMeterInfo 水表信息管理对象
     */
    public void insertSysDeviceData(SysMeterInfo sysMeterInfo)
    {
        List<SysDeviceData> sysDeviceDataList = sysMeterInfo.getSysDeviceDataList();
        Long id = sysMeterInfo.getId();
        if (StringUtils.isNotNull(sysDeviceDataList))
        {
            List<SysDeviceData> list = new ArrayList<SysDeviceData>();
            for (SysDeviceData sysDeviceData : sysDeviceDataList)
            {
                sysDeviceData.setDeviceId(id);
                list.add(sysDeviceData);
            }
            if (list.size() > 0)
            {
                sysMeterInfoMapper.batchSysDeviceData(list);
            }
        }
    }
}

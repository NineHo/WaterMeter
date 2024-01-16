package com.watermeter.web.controller.system;
import com.alibaba.fastjson.JSON;
import com.watermeter.common.config.RuoYiConfig;
import com.watermeter.system.domain.SysDeviceData;
import com.watermeter.system.domain.SysMeterAlarm;
import com.watermeter.system.mapper.SysDeviceDataMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Controller
public class SysDeviceDataController {
        private  SysDeviceDataMapper sysDeviceDataMapper;

        public SysDeviceDataController(SysDeviceDataMapper sysDeviceDataMapper) {
            this.sysDeviceDataMapper = sysDeviceDataMapper;
        }

    @RequestMapping("/system/main_v2")
    public String displayDataValue(Model model) {
        // 根据id查询记录
        List<SysDeviceData> records = sysDeviceDataMapper.findById();
        //转为json，用于echarts
        List<SysDeviceData> dataPoints = records.subList(records.size() - 5, records.size());;
        String recordsJson = JSON.toJSONString(dataPoints);
        model.addAttribute("recordsJson", recordsJson);

        //获取总流量
        BigDecimal total = BigDecimal.ZERO;
        for (SysDeviceData record : records) {
            BigDecimal dataValue = new BigDecimal(String.valueOf(record.getDataValue()));
            total = total.add(dataValue);
        }
        model.addAttribute("total", total);
        //获取最新流量
        SysDeviceData latestRecord = records.get(records.size() - 1);
        model.addAttribute("latest", latestRecord.getDataValue());
        return "main_v2";
    }
    @GetMapping("/refresh")
    public String refreshDataValue() {
        // 根据id查询记录
        List<SysDeviceData> refresh = sysDeviceDataMapper.findById();
        System.out.println(refresh);
        //转为json，用于echarts
        List<SysDeviceData> dataPoints = refresh.subList(refresh.size() - 5, refresh.size());
        String refreshJson = JSON.toJSONString(dataPoints);
        return refreshJson;
    }
    @RequestMapping("/system/main")
    public String main(ModelMap mmap,Model model)
    {
        //告警总数
        int count = sysDeviceDataMapper.getCount();
        model.addAttribute("count", count);
        //告警记录
        List<SysDeviceData> alarm = sysDeviceDataMapper.findByValue();
        model.addAttribute("alarm",alarm);
        Collections.reverse(alarm);
        mmap.put("version", RuoYiConfig.getVersion());
        //在线设备数量
        int number = sysDeviceDataMapper.getMeterNumber();
        model.addAttribute("number", number);
        return "visable";
    }

    }



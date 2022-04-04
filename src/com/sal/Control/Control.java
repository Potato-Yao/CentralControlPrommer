package com.sal.Control;

import com.sal.Calculate.Port;
import com.sal.Input.getEnvironmentData;

import java.util.HashMap;

/**
 * 控制流程
 * @author Potato Yao
 * @date 2022.3.31
 * @version b0.0.1
 */
public class Control
{
    public static HashMap<Integer, Port> ports = new HashMap<>();  // 端口
    static int id;  // 端口索引号

    /**
     * 根据Process.xml进行操作
     */
    public void process()
    {
        final double AMBIENT_TEMPERATURE = getEnvironmentData.getAmbientTemperature();
        final double AMBIENT_AIR_PRESSURE = getEnvironmentData.getAmbientAirPressure();


    }
}

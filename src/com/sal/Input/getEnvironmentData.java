package com.sal.Input;

/**
 * 获取环境信息
 * @author Potato Yao
 * @date 2022.3.31
 * @version b0.0.1
 */
public class getEnvironmentData
{
    /**
     * 获取室温，单位摄氏度
     * // TODO 东奇写
     * @return 室温
     */
    public static final double getAmbientTemperature()
    {
        double temperature = 25.0;
        return temperature;
    }

    /**
     * 获取环境气压，单位Pa
     * @return 常压
     */
    public static final double getAmbientAirPressure()
    {
        double pressure = 101000.0;
        return pressure;
    }

}

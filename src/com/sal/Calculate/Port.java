package com.sal.Calculate;

/**
 * 端口
 * @author Potato Yao
 * @date 2022.4.1
 * @version b0.0.1
 */
public class Port
{
    int portId;  // 端口ID
    String CAS;  // 物质CAS

    public Port(int portId, String CAS)
    {
        this.portId = portId;
        this.CAS = CAS;
    }

    /**
     * 与电机通信
     * TODO 不会写，让东奇写
     */
    public void connectWithMachine(String CAS)
    {

    }

    /**
     * 与电机通信，若关闭则返回false，反之true
     * @return 返回电机是否开启
     */
    public static boolean ifMotorOpen()
    {
        // TODO 需要实现电机通信后再写
        return true;
    }

    /**
     * 开启电机
     * @param time 持续时间
     * @return 是否成功完成
     */
    public boolean openMotor(double time)
    {
        // TODO 这里写一个线程，长度time秒，打开电机后关闭电机，若顺利返回true，反之false
        return !ifMotorOpen();  // 电机关闭是成功的标志
    }

}

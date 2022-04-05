package com.sal.Calculate;

import com.sal.Control.Control;

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
    String name;  // 端口名称

    public Port(int portId, String CAS, String name)
    {
        this.portId = portId;
        this.CAS = CAS;
        this.name = name;
    }

    public String getCAS()
    {
        return CAS;
    }

    public void informationPrinter()
    {
        System.out.println(portId);
        System.out.println(CAS);
        System.out.println(name);
    }

    /**
     * 将port其放于Control.java的ports中
     * @param id 索引id
     * @param port 端口
     */
    public static void putPortIntoMap(int id, Port port)
    {
        Control.ports.put(id, port);
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

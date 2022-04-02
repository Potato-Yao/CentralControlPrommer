package com.sal.Calculate;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;


/**
 * 计算类
 * @author Potato Yao
 * @date 2022.3.31
 * @version b0.0.1
 */
public class Calculate
{
    final double POWER = 1;  // 泵的功率，单位毫升/秒

    String path = "src/com/sal/Calculate/MSDS.xml";

    /**
     * 将物质的量转化为泵工作时间
     * @param port 工作端口
     * @param mol 需要的物质的量
     * @return
     */
    public double timeByMol(int port, double mol) throws IOException, ParserConfigurationException, SAXException
    {
        double molarMass = 0;
        double density = 0;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse("src/com/sal/Calculate/MSDS.xml");
        NodeList list = doc.getElementsByTagName("CAS");

        for (int i = 0; i < list.getLength(); i++)
        {
            molarMass = Double.valueOf(doc.getElementsByTagName("molarmass").item(i).getFirstChild().getNodeValue());
            density = Double.valueOf(doc.getElementsByTagName("density").item(i).getFirstChild().getNodeValue());
        }

        System.out.println(molarMass);
        System.out.println(density);

        double time = 1;  // 工作时间
        return time;
    }



    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        Document d = builder.parse("src/com/sal/Calculate/MSDS.xml");
//        NodeList list = d.getElementsByTagName("CAS");

//       for (int i = 0; i< list.getLength(); i++)
//       {
//           System.out.println(d.getElementsByTagName("id").item(i).getFirstChild().getNodeValue());
//       }
        Calculate c = new Calculate();
        c.timeByMol(1, 1.0);
    }
}

package com.sal.Calculate;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 计算类
 * @author Potato Yao
 * @date 2022.3.31
 * @version b0.0.1
 */
public class Calculate
{
    final static double POWER = 1;  // 泵的功率，单位毫升/秒

    /**
     * 将物质的量转化为泵工作时间
     * @param port 工作端口
     * @param mol 需要的物质的量
     * @return 所需的时间
     */
    public static double timeByMol(Port port, double mol) throws IOException, ParserConfigurationException, SAXException
    {
        String path = "src/com/sal/Calculate/MSDS.xml";

        String CAS = port.getCAS();

        double molarMass = 0;  // 摩尔质量
        double density = 0;  // 密度

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(path);
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("chem");

        for (int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                if (CAS.equals(element.getAttribute("cas")))
                {
                    molarMass = Integer.valueOf(element.getElementsByTagName("molarmass").item(0).getTextContent().trim());
                    density = Integer.valueOf(element.getElementsByTagName("density").item(0).getTextContent().trim());
                }
            }
        }


        double time = 1;  // 工作时间
        time = (mol * molarMass) / (density * POWER);
        return time;
    }

    /**
     * 将物质的量转化为泵工作时间
     * @param port 端口
     * @param mol 需要的物质的量
     * @param concentration 溶液的物质的量浓度
     * @return 所需的时间
     */
    public double timeByMol(int port, double mol, double concentration)
    {
        double time = 1;
        time = mol / (concentration * POWER);
        return time;
    }
}

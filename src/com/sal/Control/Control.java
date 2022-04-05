package com.sal.Control;

import com.sal.Calculate.Calculate;
import com.sal.Calculate.Port;
import com.sal.Input.getEnvironmentData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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
    public void process(String xmlUrl) throws ParserConfigurationException, IOException, SAXException
    {
        final double AMBIENT_TEMPERATURE = getEnvironmentData.getAmbientTemperature();
        final double AMBIENT_AIR_PRESSURE = getEnvironmentData.getAmbientAirPressure();

        // 创建DOM解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(xmlUrl);
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("process");

        for (int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                var port = Control.ports.get(Integer.valueOf(element.getAttribute("port")));
                port.openMotor(Calculate.timeByMol(port, Integer.valueOf(element.getElementsByTagName("start").item(0).getTextContent().trim())));
            }
        }
    }
}

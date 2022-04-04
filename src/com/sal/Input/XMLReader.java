package com.sal.Input;

import com.sal.Calculate.Port;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import com.sal.Control.Control;

/**
 * 读取Port.xml和MSDS.xml，Process.xml
 * @author Potato Yao
 * @date 2022.4.4
 * @version b0.0.1
 */
public class XMLReader
{

    /**
     * 端口读取
     * @param url 端口文件位置
     */
    public static void portReader(String url) throws IOException, SAXException, ParserConfigurationException
    {
        // 创建DOM解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(url);
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("port");  // 以port节点下的节点作为一个列表

        // 遍历中的每一个值
        for (int i = 0; i < list.getLength(); i++)
        {
            // 将列表中的每一项作为节点类型
            Node node = list.item(i);
            // 如果该项是节点，则使用节点继续遍历
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                int id = Integer.parseInt(element.getAttribute("id"));  // 节点的属性“id”，由于只有port节点有这个属性，所以可以直接对全部节点做遍历
                String CAS = element.getElementsByTagName("CAS").item(0).getTextContent().trim();  // 获取CAS节点的值
                String name = element.getElementsByTagName("name").item(0).getTextContent().trim();  // 获取name节点的值
                Port port = new Port(id, CAS, name);  // 将值赋予新的port类
                port.informationPrinter();
                Control.ports.put(i, port);
            }
        }
    }

    public static void processReader(String url) throws IOException, SAXException, ParserConfigurationException
    {
        // 创建DOM解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(url);
        doc.getDocumentElement().normalize();
    }
}

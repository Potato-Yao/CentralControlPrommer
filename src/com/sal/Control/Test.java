package com.sal.Control;

import com.sal.Input.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.sal.Control.Control.ports;

public class Test
{
    static String path = "src/com/sal/Control/Ports.xml";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
    {
        XMLReader.portReader(path);
        for (int id : ports.keySet())
        {
            System.out.println(id);
            System.out.println(ports.get(id));
        }
    }
}

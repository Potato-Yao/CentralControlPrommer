package com.sal.Control;

import com.sal.Input.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
    {
        XMLReader.processReader("src/com/sal/Control/Process.txt", "src/com/sal/Control/Process.xml");
    }
}

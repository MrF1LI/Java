import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XMLUtils {

    public static void createXML() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement("students");
        document.appendChild(rootElement);

        Element studentElement = document.createElement("student");
        studentElement.setAttribute("id", "1");
        rootElement.appendChild(studentElement);

        Element firstNameElement = document.createElement("firstname");
        firstNameElement.appendChild(document.createTextNode("kanistrate"));
        studentElement.appendChild(firstNameElement);

        Element lastNameElement = document.createElement("lastname");
        lastNameElement.appendChild(document.createTextNode("leptopashvili"));
        studentElement.appendChild(lastNameElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("C:\\baroBrat\\file.xml"));

        transformer.transform(domSource, streamResult);

    }

    public static void parseXML() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("C:\\baroBrat\\file.xml"));
        document.getDocumentElement().normalize();

        NodeList studentID = document.getElementsByTagName("student");
        System.out.println("student id : " + studentID.item(0).getAttributes().getNamedItem("id").getNodeValue());

        NodeList nodeList = document.getElementsByTagName("firstname");
        System.out.println("student firstname : " + nodeList.item(0).getTextContent());

        NodeList nodeList1 = document.getElementsByTagName("lastname");
        System.out.println("student lastname : " + nodeList1.item(0).getTextContent());

    }

}

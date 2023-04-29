import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

public class Main {
    public static void main(String[] args) {
        // Work 1 call
        int[] numbers = {150, 24, 65, 151, 152};
        System.out.println(averageOf(numbers));

        try {
            generateXml();
        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    // Work 1
    public static float averageOf(int[] numbers) {
        float sum = 0;
        int count = 0;

        for (int number : numbers) {
            if (number > 150) {
                sum += number;
                count++;
            }
        }

        return sum / count;
    }

    // Work 2

    public static double geometricMeanOfOddNumbers(int[] numbers) {
        double product = 1.0;
        int count = 0;

        for (int number : numbers) {
            if (number % 2 != 0) {
                product *= number;
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return Math.pow(product, 1.0 / count);
    }

    // Work 4
    public static void generateXml() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        // Create document
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        // Create elements
        Element rootElement = document.createElement("departments");
        document.appendChild(rootElement);

        // Department 1
        Element departmentElement = document.createElement("department");
        rootElement.appendChild(departmentElement);

        Element name = document.createElement("name");
        name.appendChild(document.createTextNode("HR"));
        departmentElement.appendChild(name);

        Element email = document.createElement("email");
        email.appendChild(document.createTextNode("hr@oracle.com"));
        departmentElement.appendChild(email);

        // Department 2
        Element department1Element = document.createElement("department");
        rootElement.appendChild(department1Element);

        Element name1 = document.createElement("name");
        name1.appendChild(document.createTextNode("IT"));
        department1Element.appendChild(name1);

        Element email1 = document.createElement("email");
        email1.appendChild(document.createTextNode("it@java.com"));
        department1Element.appendChild(email1);

        //
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("departments.xml"));
        transformer.transform(domSource, streamResult);
    }
}

package supporter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ResourceAccesser {
	public static final HashMap<String, String> dbInfo = readXmlDbInfo("src/main/resources/ConnectionInfo.xml");

	private static HashMap<String, String> readXmlDbInfo(String fileName) {
		HashMap<String, String> dbInfoMap = new HashMap<String, String>();
		Document xml = null;
		Node addressNode = null;
		Node connectionIdNode = null;
		Node connectionPassWdNode = null;
		try {
			xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			addressNode = (Node) xpath.evaluate("//connectionInfo/address", xml, XPathConstants.NODE);
			connectionIdNode = (Node) xpath.evaluate("//connectionInfo/connectionId", xml, XPathConstants.NODE);
			connectionPassWdNode = (Node) xpath.evaluate("//connectionInfo/connectionPassWd", xml, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		dbInfoMap.put("address", addressNode.getTextContent());
		dbInfoMap.put("connectionId", connectionIdNode.getTextContent());
		dbInfoMap.put("connectionPassWd", connectionPassWdNode.getTextContent());
		return dbInfoMap;
	}
}

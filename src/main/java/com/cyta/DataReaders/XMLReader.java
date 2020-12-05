package com.cyta.DataReaders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import org.w3c.dom.Document;
import org.w3c.dom.Element; 
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  

public class XMLReader {
	
	private static Document doc;
	
	//load XML document in doc variable with the file path
	public static Document readXMLdoc(String FilePath)   
	{  
		try   
		{  
			//creating a constructor of file class and parsing an XML file  
			File file = new File(FilePath);  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			doc = db.parse(file);  
			doc.getDocumentElement().normalize();  
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			return doc;
			 
		}   
		catch (Exception e)   
		{  
			e.printStackTrace(); 
			System.out.println(e);
			return null;
		}  
	}
	
	//read child value with the child name and its parent tag name
	public static List<String> getValueByNodeName(String ParentNode, String ChildNode)
	{
		List<String> ChildsValues = new ArrayList<String>();
		try {
			NodeList nodeList = doc.getElementsByTagName(ParentNode);  
			// nodeList is not iterable, so we are using for loop  
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
				Node node = nodeList.item(itr);  
				System.out.println("\nNode Name :" + node.getNodeName());  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{  
					Element eElement = (Element) node;  
					System.out.println(ChildNode+" :" + eElement.getElementsByTagName(ChildNode).item(0).getTextContent());  
					ChildsValues.add(eElement.getElementsByTagName(ChildNode).item(0).getTextContent());
				}  
			}  
			
			return ChildsValues;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
			return null;
		}
	}

}

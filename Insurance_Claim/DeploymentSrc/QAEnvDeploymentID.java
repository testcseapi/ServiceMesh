import java.io.File;
import java.io.PrintWriter;

import org.w3c.dom.*;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class QAEnvDeploymentID{

public static void main (String argv []){
try {

DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
Document doc = docBuilder.parse (new File("QAEnvDeploymentID.xml"));

NodeList listOfPersons = doc.getElementsByTagName("ns1:deployments");
int s = listOfPersons.getLength();
System.out.println("Total no of links : " + s);


Node firstPersonNode = listOfPersons.item(s-1);

Element firstPersonElement = (Element)firstPersonNode; 

//-------
NodeList firstNameList = firstPersonElement.getElementsByTagName("ns1:id");
Element firstNameElement = (Element)firstNameList.item(0);

NodeList textFNList = firstNameElement.getChildNodes();
System.out.println("ID : " + ((Node)textFNList.item(0)).getNodeValue().trim());

PrintWriter writer = new PrintWriter("QAEnvDeploymentID.txt", "UTF-8");
writer.println(((Node)textFNList.item(0)).getNodeValue().trim());
writer.close();




}catch (SAXParseException err) {
System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
System.out.println(" " + err.getMessage ());

}catch (SAXException e) {
Exception x = e.getException ();
((x == null) ? e : x).printStackTrace ();

}catch (Throwable t) {
t.printStackTrace ();
}
//System.exit (0);

}//end of main


}
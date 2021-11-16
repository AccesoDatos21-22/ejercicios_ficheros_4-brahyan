package dao;

import java.nio.file.Path;

import modelo.Farmacia;

import org.w3c.dom.*;

import javax.xml.parsers.*;

public class FarmaciaDOM{

	/**
	 * Lee los medicamentos de la farmacia de un fichero xml
	 * mediante DOM
	 * @param farmacia
	 * @return
	 */
	public boolean leer(Path farmaciaXML) {
		return false;
		
	}
	
	/**
	 * Guarda los medicamentos de la farmacia en un fichero XML 
	 * mediamente DOM
	 * @param farmacia
	 * @return
	 */
	public boolean guardar(Farmacia farmacia) {
		
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Medicamentos",null);
			document.setXmlVersion("1.0"); //asignamos la version de nuestro XML
			
			Element raiz = document.createElement("Medicamentos"); 				
			document.getDocumentElement().appendChild(raiz); 
			
			

		}catch (Exception e) {
			
		}
			

		return false;
		
	}

}

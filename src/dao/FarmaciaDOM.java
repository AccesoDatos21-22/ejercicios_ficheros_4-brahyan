package dao;

import java.nio.file.Path;

import modelo.Farmacia;
import modelo.Medicamento;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
			 
			for (Medicamento med : farmacia.leerTodos() ) {
				Element medicamento = document.createElement("medicamento");
				addMedicamento(document,medicamento, "Codigo", Integer.toString( med.getCod()) );
				addMedicamento(document,medicamento, "Nombre", med.getNombre() );
				addMedicamento(document,medicamento, "Precio", Double.toString(med.getPrecio()) );
				addMedicamento(document,medicamento, "Stock", Integer.toString( med.getStock()) );
				addMedicamento(document,medicamento, "StockMaximo", Integer.toString( med.getStockMaximo()) );
				addMedicamento(document,medicamento, "StockMinimo", Integer.toString( med.getStockMinimo()) );
				addMedicamento(document,medicamento, "Proveedor", Integer.toString( med.getCodProveedor()) );
				
				document.getDocumentElement().appendChild(medicamento);
			}
			
			
			//***Guardado del documento-------
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("Medicamentos.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");			
			transformer.setOutputProperty( "{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source,  result);	

		}catch (Exception e) {
			
		}
		
		return false;
		
	}
	
	private void addMedicamento(Document documento,Element elementoPadre, String etiqueta, String valor ) {
		
		Element tag = documento.createElement( etiqueta );
		Text value = documento.createTextNode( valor );
		tag.appendChild(value);
		elementoPadre.appendChild(tag);
	}
	
	

}

package dao;

import java.io.File;
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
		
		boolean leidoCorrectamente = false;
		
		return leidoCorrectamente;
	}
	
	/**
	 * Guarda los medicamentos de la farmacia en un fichero XML 
	 * mediamente DOM
	 * @param farmacia
	 * @return
	 */
	public boolean guardar(Farmacia farmacia) {
		
		boolean guardado = false;
		
		try{
			//Creacion del documento XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			//Creacion de la etiqueta raiz del documento
			Document document = implementation.createDocument(null, "Medicamentos",null);
			document.setXmlVersion("1.0"); //asignamos la version de nuestro XML			
			 
			for (Medicamento med : farmacia.leerTodos() ) {
				//Creacion de etiqueta <medicamento> que luego se añadira a la raiz <medicamentos>
				Element medicamento = document.createElement("medicamento");
				//Se crea una etiqueta hija para cada propiedad del medicamento con su valor y se anida en <medicamento>
				addMedicamento(document,medicamento, "Codigo", Integer.toString( med.getCod()) );
				addMedicamento(document,medicamento, "Nombre", med.getNombre() );
				addMedicamento(document,medicamento, "Precio", Double.toString(med.getPrecio()) );
				addMedicamento(document,medicamento, "Stock", Integer.toString( med.getStock()) );
				addMedicamento(document,medicamento, "StockMaximo", Integer.toString( med.getStockMaximo()) );
				addMedicamento(document,medicamento, "StockMinimo", Integer.toString( med.getStockMinimo()) );
				addMedicamento(document,medicamento, "Proveedor", Integer.toString( med.getCodProveedor()) );
				//Se añade medicamento al elemento raiz <medicamentos>
				document.getDocumentElement().appendChild(medicamento);
			}
			
			
			//***Guardado del documento en un fichero en el directorio de trabajo
			Source source = new DOMSource(document);
			Result result = new StreamResult(new File("Medicamentos.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			//Propiedades del fichero XML de salida
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");			
//			transformer.setOutputProperty( "{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source,  result);	
			//Se ha guardado sin fallos
			guardado = true;
		}catch (Exception e) {
			System.err.println("ERROR al guardar los medicamentos en el fichero XML");
		}
		
		return guardado;
		
	}
	
	private void addMedicamento(Document documento,Element elementoPadre, String etiqueta, String valor ) {
		
		Element tag = documento.createElement( etiqueta );
		Text value = documento.createTextNode( valor );
		tag.appendChild(value);
		elementoPadre.appendChild(tag);
	}
	
	

}

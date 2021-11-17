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
	//Nombre del fichero que guardara los medicamentos
	public final String FICHERO_FARMACIA = "Medicamentos.xml";
	//Etiqueta que guardara cada medicamento
	private final String ETIQUETA_MEDICAMENTO = "Medicamento";
	//Propiedades de los medicamentos que se guardaran
	private static final String CODIGO_MEDICAMENTO = "Codigo";
	private static final String NOMBRE_MEDICAMENTO = "Nombre";
	private static final String PRECIO_MEDICAMENTO = "Precio";
	private static final String STOCK_MEDICAMENTO = "Stock";
	private static final String STOCK_MAXIMO_MEDICAMENTO = "StockMaximo";
	private static final String STOCK_MINIMO_MEDICAMENTO = "StockMinimo";
	private static final String PROVEEDOR_MEDICAMENTO = "Proveedor";
	
	public Farmacia leer(Path farmaciaXML) {
		
		Farmacia farmaciaLeida = new Farmacia();
		
		try {
			//Obtencion de instancia de DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			//Parseado del documento XML
			Document document = builder.parse(  farmaciaXML.toAbsolutePath().resolve(FICHERO_FARMACIA).toFile()  );
			//Normalizacion del contenido del fichero para poder tratarlo
			document.getDocumentElement().normalize();
			//Se obtienen todos los elementos medicamento del documento
			NodeList listaMedicamentos = document.getElementsByTagName(ETIQUETA_MEDICAMENTO);
			
			for ( int i=0; i<listaMedicamentos.getLength();i++ ) {
				//Obtenemos el nodo medicamento en cada iteracion
				Node nodoMedicamento = listaMedicamentos.item(i);
				//Comprobamos que el nodo que tenemos es un elemento y no otro tipo de nodo
				if ( nodoMedicamento.getNodeType() == Node.ELEMENT_NODE) {
					//Casteamos el nodo a elemento ya que ya sabemos que es un elemento
					Element medicamento = (Element) nodoMedicamento;
					//Guardado de los datos de cada medicamento para añadirlo a la farmacia
					int codigo = Integer.parseInt( getChilNodeValue(medicamento, CODIGO_MEDICAMENTO) );
					String nombre = getChilNodeValue(medicamento, NOMBRE_MEDICAMENTO);
					double precio = Double.parseDouble( getChilNodeValue(medicamento, PRECIO_MEDICAMENTO) );
					int stock = Integer.parseInt( getChilNodeValue(medicamento, STOCK_MEDICAMENTO) );
					int stockMaximo = Integer.parseInt( getChilNodeValue(medicamento, STOCK_MAXIMO_MEDICAMENTO) );
					int stockMinimo = Integer.parseInt( getChilNodeValue(medicamento, STOCK_MINIMO_MEDICAMENTO) );
					int proveedor = Integer.parseInt( getChilNodeValue(medicamento, PROVEEDOR_MEDICAMENTO) );
					//Guardado del medicamento leido en la farmacia
					farmaciaLeida.guardar( new Medicamento(codigo, nombre, precio, stock, stockMaximo, stockMinimo, proveedor) );
				}
				
			}

		} catch (Exception e) {
			System.err.println("ERROR en la lectura de los medicamentos del fichero XML");
		}
		
		return farmaciaLeida;
	}
	
	private String getChilNodeValue ( Element elemento, String nodoHijo ) {
		//Captura el valor de la etiqueta hija buscada, en el elemento deseado
		Element nodo = (Element) elemento.getElementsByTagName(nodoHijo).item(0);
		return nodo.getTextContent();
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
				Element medicamento = document.createElement(ETIQUETA_MEDICAMENTO);
				//Se crea una etiqueta hija para cada propiedad del medicamento con su valor y se anida en <medicamento>
				addMedicamento(document,medicamento, CODIGO_MEDICAMENTO , Integer.toString( med.getCod()) );
				addMedicamento(document,medicamento, NOMBRE_MEDICAMENTO , med.getNombre() );
				addMedicamento(document,medicamento, PRECIO_MEDICAMENTO , Double.toString(med.getPrecio()) );
				addMedicamento(document,medicamento, STOCK_MEDICAMENTO , Integer.toString( med.getStock()) );
				addMedicamento(document,medicamento, STOCK_MAXIMO_MEDICAMENTO , Integer.toString( med.getStockMaximo()) );
				addMedicamento(document,medicamento, STOCK_MINIMO_MEDICAMENTO , Integer.toString( med.getStockMinimo()) );
				addMedicamento(document,medicamento, PROVEEDOR_MEDICAMENTO , Integer.toString( med.getCodProveedor()) );
				//Se añade medicamento al elemento raiz <medicamentos>
				document.getDocumentElement().appendChild(medicamento);
			}
			
			
			//***Guardado del documento en un fichero en el directorio de trabajo
			Source source = new DOMSource(document);
			Result result = new StreamResult(new File(FICHERO_FARMACIA));
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoxml.xmlManager;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import proyectoxml.Alumno.Alumno;

/**
 *
 * @author melvi
 */
public class XmlManager {

    private String filePath = "alumnos.xml";

    private File archivoXml;

    private Document document;

    public XmlManager() {
        validateExistXml();
    }

    private void validateExistXml() {
        File xmlFile = new File(filePath);
        if (xmlFile.exists()) {
            readXml();
        } else {
            createXml();
            readXml();
        }
    }

    private void readXml() {
        try {
            archivoXml = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            document = builder.parse(archivoXml);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbFactory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document document = implementation.createDocument(null, "alumnos", null);
        document.setXmlVersion("1.0");

        return document;
    }

    private void createXml() {
        try {

            Document document = createDocument();

            Source source = new DOMSource(document);

            Result result = new StreamResult(new File(filePath));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Alumno getAlumnoById(String id) {
        Alumno alumno = null;
        readXml();

        NodeList listaAlumnos = document.getElementsByTagName("alumno");

        for (int i = 0; i < listaAlumnos.getLength(); i++) {
            Node alumnoNode = listaAlumnos.item(i);
            if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                Element alumnoValido = (Element) alumnoNode;

                String idBuscado = alumnoValido.getElementsByTagName("id").item(0).getTextContent();

                if (id.equals(idBuscado)) {
                    alumno = this.parseAlumnoFromXml(alumnoValido);
                }
            }
        }

        return alumno;
    }

    public boolean createAlumno(Alumno alumno) throws Exception {
        readXml();
        try {
            Element alumnos = document.getDocumentElement();

            Element alumnoNuevo = document.createElement("alumno");

            Element nombre = document.createElement("nombre");
            nombre.setTextContent(alumno.getNombre());

            Element edad = document.createElement("edad");
            edad.setTextContent(alumno.getEdad());

            Element telefono = document.createElement("telefono");
            telefono.setTextContent(alumno.getTelefono());

            Element identidad = document.createElement("identidad");
            identidad.setTextContent(alumno.getIdentidad());

            Element email = document.createElement("email");
            email.setTextContent(alumno.getEmail());

            Element sexo = document.createElement("sexo");
            sexo.setTextContent(alumno.getSexo());

            Element id = document.createElement("id");
            id.setTextContent(alumno.getId());

            alumnoNuevo.appendChild(nombre);
            alumnoNuevo.appendChild(edad);
            alumnoNuevo.appendChild(telefono);
            alumnoNuevo.appendChild(identidad);
            alumnoNuevo.appendChild(email);
            alumnoNuevo.appendChild(sexo);
            alumnoNuevo.appendChild(id);

            alumnos.appendChild(alumnoNuevo);

            saveChanges();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al crear el alumno");
        }
    }

    public boolean updateAlumno(Alumno updatedAlumno) throws Exception {
        if (getAlumnoById(updatedAlumno.getId()) == null) {
            throw new Exception("No existe el alumno");
        }
        readXml();
        try {
            NodeList listaAlumnos = document.getElementsByTagName("alumno");

            for (int i = 0; i < listaAlumnos.getLength(); i++) {
                Node alumno = listaAlumnos.item(i);
                if (alumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoValido = (Element) alumno;

                    String id = alumnoValido.getElementsByTagName("id").item(0).getTextContent();

                    if (id.equals(updatedAlumno.getId())) {
                        alumnoValido.getElementsByTagName("nombre").item(0).setTextContent(updatedAlumno.getNombre());
                        alumnoValido.getElementsByTagName("edad").item(0).setTextContent(updatedAlumno.getEdad());
                        alumnoValido.getElementsByTagName("telefono").item(0).setTextContent(updatedAlumno.getTelefono());
                        alumnoValido.getElementsByTagName("identidad").item(0).setTextContent(updatedAlumno.getIdentidad());
                        alumnoValido.getElementsByTagName("email").item(0).setTextContent(updatedAlumno.getEmail());
                        alumnoValido.getElementsByTagName("sexo").item(0).setTextContent(updatedAlumno.getSexo());
                    }
                }
            }

            saveChanges();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar el alumno");
        }
        return true;
    }

    private boolean saveChanges() {
        try {
            Source input = new DOMSource(document);

            Result output = new StreamResult(new File(filePath));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.transform(input, output);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar los cambios");
            return false;
        }
        return true;
    }

    public ArrayList<Alumno> listarAlumnos() {

        readXml();
        NodeList alumnosXml = document.getElementsByTagName("alumno");

        ArrayList<Alumno> alumnosArray = new ArrayList<Alumno>();

        for (int i = 0; i < alumnosXml.getLength(); i++) {

            Node alumnoXml = alumnosXml.item(i);
            if (alumnoXml.getNodeType() == Node.ELEMENT_NODE) {
                Element alumnoValido = (Element) alumnoXml;

                Alumno parcedAlumno = this.parseAlumnoFromXml(alumnoValido);

                alumnosArray.add(parcedAlumno);
            }
        }

        return alumnosArray;
    }

    private Alumno parseAlumnoFromXml(Element alumnoFromXml) {
        String nombre = alumnoFromXml.getElementsByTagName("nombre").item(0).getTextContent();
        String edad = alumnoFromXml.getElementsByTagName("edad").item(0).getTextContent();
        String telefono = alumnoFromXml.getElementsByTagName("telefono").item(0).getTextContent();
        String identidad = alumnoFromXml.getElementsByTagName("identidad").item(0).getTextContent();
        String email = alumnoFromXml.getElementsByTagName("email").item(0).getTextContent();
        String sexo = alumnoFromXml.getElementsByTagName("sexo").item(0).getTextContent();
        String idXml = alumnoFromXml.getElementsByTagName("id").item(0).getTextContent();

        return new Alumno(nombre, edad, telefono, identidad, email, sexo, idXml);
    }

    public boolean deleteAlumno(String id) throws Exception {
        if (getAlumnoById(id) == null) {
            throw new Exception("No existe el alumno");
        }
        readXml();

        NodeList alumnos = document.getElementsByTagName("alumno");

        Element alumnosTag = document.getDocumentElement();

        for (int i = 0; i < alumnos.getLength(); i++) {

            Node alumnoXml = alumnos.item(i);
            if (alumnoXml.getNodeType() == Node.ELEMENT_NODE) {
                Element alumnoValido = (Element) alumnoXml;

                String idXml = alumnoValido.getElementsByTagName("id").item(0).getTextContent();

                if (id.equals(idXml)) {
                    alumnosTag.removeChild(alumnoXml);
                    saveChanges();
                    return true;
                }

            }
        }

        return false;
    }

    public ArrayList<Alumno> searchByName(String nombreBuscado) throws Exception {

        readXml();
        NodeList alumnosXml = document.getElementsByTagName("alumno");

        ArrayList<Alumno> alumnosArray = new ArrayList<Alumno>();

        if (alumnosXml.getLength() == 0) {
            throw new Exception("No hay datos para mostrar");
        }

        for (int i = 0; i < alumnosXml.getLength(); i++) {

            Node alumnoXml = alumnosXml.item(i);
            if (alumnoXml.getNodeType() == Node.ELEMENT_NODE) {
                Element alumnoValido = (Element) alumnoXml;
                String nombre = alumnoValido.getElementsByTagName("nombre").item(0).getTextContent();

                boolean seEncontro = nombre.toLowerCase().contains(nombreBuscado.toLowerCase());

                if (seEncontro) {
                    Alumno parcedAlumno = this.parseAlumnoFromXml(alumnoValido);
                    alumnosArray.add(parcedAlumno);
                }
            }
        }

        if (alumnosArray.size() == 0) {
            throw new Exception("No se encontro el alumno");
        }

        return alumnosArray;
    }
}

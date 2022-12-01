/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoxml;

import proyectoxml.Alumno.Alumno;
import proyectoxml.xmlManager.XmlManager;

/**
 *
 * @author melvi
 */
public class Main {

    public static void main(String[] args) throws Exception {
        XmlManager xmlmanager = new XmlManager();

        Alumno alunmo = new Alumno("Melvin", "20", "98897509", "04040300200383", "melvinjoe@gmail.com", "M");
        
        xmlmanager.createAlumno(alunmo);
    
        System.out.println("hola desde mi pc");
    }
}

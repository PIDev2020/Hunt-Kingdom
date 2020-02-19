/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.API;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pidev.Entite.Commande;
import pidev.Service.ServiceCommande;



/**
 *
 * @author hp
 */
public class GeneratePdf {
    
    public static void main(String[] args) throws FileNotFoundException, DocumentException, SQLException{
    String file_name="C:\\Users\\hp\\Documents\\NetBeansProjects\\testcommande2\\test.pdf";
    ServiceCommande se= new ServiceCommande();
    try{
   List<Commande> listC = se.readAll();
    
   Document document = new Document();
   
   PdfWriter.getInstance(document , new FileOutputStream(file_name));
   document.open();
   
   Paragraph p = new Paragraph();
   p.add(listC.toString());

   document.add(p);
   
   document.close();
    }
    catch(SQLException e)
    {
        System.out.println(e);
    }
    }


    }
}

package com.proiect_PS.resurse.factory;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.proiect_PS.resurse.dto.CartCredentialsDTO;
import com.proiect_PS.resurse.model.Orders;
import com.proiect_PS.resurse.model.Product;
import com.proiect_PS.resurse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class PdfGenerator {


    public void generate(Orders order) throws FileNotFoundException, DocumentException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("raport.pdf"));
        document.open();
        com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        Paragraph paragraphOne = new Paragraph("Factura comanda", redFont);
        document.add(paragraphOne);



        Paragraph paragraph = new Paragraph("Comanda :"+order.getOrderId());
        document.add(paragraph);
        Paragraph paragraph1 = new Paragraph("Client:"+order.getCustomer().getFirstName() + " "+order.getCustomer().getLastName());
        document.add(paragraph1);
        Paragraph paragraph2 = new Paragraph("Adresa de facturare:"+order.getCustomer().getAddress());
        document.add(paragraph2);
        Paragraph paragraph3 = new Paragraph("Cod postal:"+order.getCustomer().getZipcode());
        document.add(paragraph3);

        Chunk chunk = new Chunk("Produse :");


        Paragraph para1 = new Paragraph(chunk);
        para1.setAlignment(Paragraph.ALIGN_CENTER);
        para1.setSpacingAfter(50);
        document.add(para1);
        Chunk chunk2 = new Chunk("Produse :");

        for(int i=0;i<order.getCustomer().getProducts().size();i++){
            Chunk chunk3 = new Chunk("Nume produs:"+String.valueOf(order.getCustomer().getProducts().get(i).getProductName())+"    "+"pret " +
                    String.valueOf(order.getCustomer().getProducts().get(i).getProductPrice())+ " RON");
        Paragraph para2 = new Paragraph(chunk3);
        para2.setAlignment(Paragraph.ALIGN_CENTER);
        para2.setSpacingAfter(50);
        document.add(para2);}

        Paragraph p=new Paragraph("Total :"+order.getTotalSum()+" RON");
        document.add(p);






        document.close();
    }
}
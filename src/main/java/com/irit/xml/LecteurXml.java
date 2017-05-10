package com.irit.xml;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by mkostiuk on 09/05/2017.
 */
public class LecteurXml {

    private StockReponses stockReponses;

    public LecteurXml(String xml) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
          boolean isNbQuestions = false;
          boolean isNbReponses = false;
          boolean isNumero = false;
          boolean isEndQuestion = false;
          boolean isQuestion = false;
          Integer num ;
          Integer nbR ;

          @Override
          public void startElement(String uri, String localName, String qName, Attributes attributes) {
              if (qName.equalsIgnoreCase("NombreQuestion"))
                  isNbQuestions = true;
              if (qName.equalsIgnoreCase("NbReponse"))
                  isNbReponses = true;
              if (qName.equalsIgnoreCase("Numero"))
                  isNumero = true;
          }
          
          @Override
          public void endElement(String uri, String localName, String qName) {
              if (qName.equalsIgnoreCase("Question")) {
                  System.out.println("FIN QUESTION" + " " + num + " " + nbR);
                  num++;
                  for(int i = 0; i < nbR; i++)
                     stockReponses.addReponse(num);
              }
          }

          @Override
          public void characters(char ch[], int start, int length) {
              if (isNbQuestions) {
                  isNbQuestions = false;
                  String nbQ = new String(ch, start, length);
                  stockReponses = new StockReponses(Integer.valueOf(nbQ));
              }
              if (isNumero) {
                  isNumero = false;
                  num = Integer.valueOf(new String(ch, start, length));
              }
              if (isNbReponses) {
                  isNbReponses = false;
                  nbR = Integer.valueOf(new String(ch, start, length));
              }
          }
        };
        sp.parse(new InputSource(new StringReader(xml)), handler);
    }

    public StockReponses getStockReponses() {
        return stockReponses;
    }
}

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
          String num = "";

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
          public void characters(char ch[], int start, int length) {
              if (isNbQuestions) {
                  isNbQuestions = false;
                  String nbQ = new String(ch, start, length);
                  stockReponses = new StockReponses(Integer.valueOf(nbQ));
              }
              if (isNumero) {
                  isNumero = false;
                  num = new String(ch, start, length);
              }
              if (isNbReponses) {
                  isNbReponses = false;
                  String nbR = new String (ch, start, length);

                  for(int i = 0; i < Integer.valueOf(nbR); i++)
                     stockReponses.addReponse(Integer.valueOf(num));
              }
          }
        };
        sp.parse(new InputSource(new StringReader(xml)), handler);
    }

    public StockReponses getStockReponses() {
        return stockReponses;
    }
}

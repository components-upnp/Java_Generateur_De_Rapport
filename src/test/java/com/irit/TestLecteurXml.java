package com.irit;

import com.irit.xml.LecteurXml;
import com.irit.xml.StockReponses;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by mkostiuk on 12/05/2017.
 */
public class TestLecteurXml extends TestCase {

    private StockReponses sr;
    private LecteurXml l;
    private final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Reponses><NombreQuestion>3</NombreQuestion><Question><Numero>0</Numero><NbReponse>2</NbReponse></Question><Question><Numero>1</Numero><NbReponse>1</NbReponse></Question><Question><Numero>2</Numero><NbReponse>0</NbReponse></Question></Reponses>";

    @Before
    public void setUp() throws IOException, SAXException, ParserConfigurationException {
        l = new LecteurXml(xml);
        sr = l.getStockReponses();
    }

    @Test
    public void testNbReponsesOk() {
        assertEquals(3,sr.getNbQuestions());
    }

    @Test
    public void testNbReponse1() {
        assertEquals(2, sr.getVoteReponse(1));
    }

    @Test
    public void testNbReponse2() {
        assertEquals(1,sr.getVoteReponse(2));
    }

    @Test
    public void testNbReponse3() {
        assertEquals(0, sr.getVoteReponse(3));
    }

    @Test
    public void testReponseInvalide() {
        boolean isPassed = false;

        try {
            sr.getVoteReponse(0);
        } catch (NullPointerException ex) {
            isPassed = true;
        }

        assertTrue(isPassed);
    }
}

package test.java.com.irit;

import com.irit.xml.StockReponses;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mkostiuk on 12/05/2017.
 */
public class TestStockReponses extends TestCase {

    private StockReponses sr;


    @Before
    public void setUp() {
        sr = new StockReponses(2);
    }

    @Test
    public void testNbQuestions() {
        assertEquals(2, sr.getNbQuestions());
    }

    @Test
    public void testAddReponseOk() {
        sr.addReponse(0);
        assertEquals(1, sr.getVoteReponse(0));
    }

    @Test
    public void testGetNbReponses0() {
        assertEquals(0, sr.getNbVotes());
    }

    @Test
    public void testGetNbReponses5() {
        sr.addReponse(0);
        sr.addReponse(1);
        sr.addReponse(0);
        sr.addReponse(1);
        sr.addReponse(0);
        assertEquals(5, sr.getNbVotes());
    }


}

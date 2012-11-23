import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.FractionNumber
import org.bernshtam.matex.Sign

import org.junit.Test

import static junit.framework.Assert.assertEquals

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/22/12
 * Time: 4:43 PM
 */
class TestFormula {

    @Test
    void test2Parts() {
        FractionNumber n1 = new FractionNumber(1,1,2)
        FractionNumber n2 = new FractionNumber(0,1,2)
        FractionFormula f1 = new FractionFormula(n1,n2,Sign.PLUS)
        FractionFormula f2 = new FractionFormula(n1,n2,Sign.MINUS)
        FractionFormula f3 = new FractionFormula(n1,n2,Sign.MULT)
        FractionFormula f4 = new FractionFormula(n1,n2,Sign.DIV)


        assertEquals(f1.compute(), new FractionNumber(2,0,1))
        assertEquals(f2.compute(), new FractionNumber(1,0,1))
        assertEquals(f3.compute(), new FractionNumber(0,3,4))
        assertEquals(f4.compute(), new FractionNumber(3,0,1))
    }

    @Test
    void test3Parts() {
        FractionNumber n1 = new FractionNumber(1,1,2)
        FractionNumber n2 = new FractionNumber(0,1,2)
        FractionNumber n3 = new FractionNumber(1,0,1)
        FractionFormula f1 = new FractionFormula(n1,n2,n3,Sign.PLUS,Sign.MULT)
        FractionFormula f2 = new FractionFormula(n1,n2,n3,Sign.MINUS,Sign.DIV)
        FractionFormula f3 = new FractionFormula(n1,n2,n3,Sign.MULT,Sign.MINUS)
        FractionFormula f4 = new FractionFormula(n1,n2,n3,Sign.DIV,Sign.PLUS)
        FractionFormula f5 = new FractionFormula(n1,n2,n3,Sign.MINUS,Sign.PLUS)
        FractionFormula f6 = new FractionFormula(n1,n2,n3,Sign.DIV,Sign.MULT)


        assertEquals(f1.compute(), new FractionNumber(2,0,1))
        assertEquals(f2.compute(), new FractionNumber(1,0,1))
        assertEquals(f3.compute(), new FractionNumber(0,-1,4))
        assertEquals(f4.compute(), new FractionNumber(4,0,1))
        assertEquals(f5.compute(), new FractionNumber(2,0,1))
        assertEquals(f6.compute(), new FractionNumber(3,0,1))
    }
}

import org.bernshtam.matex.FractionNumber
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/19/12
 * Time: 11:11 AM
 */
class TestSumSub {

    @Test
    void testFrac() {
        FractionNumber f = new FractionNumber(1,14,6)
        assertEquals("whole",3,f.properWhole)
        assertEquals("properNumerator",2,f.properNumerator)
        assertEquals("denominator",6,f.denominator)

        FractionNumber f1 = f.reduce()
        assertEquals("whole",3,f1.properWhole)
        assertEquals("properNumerator",1,f1.properNumerator)
        assertEquals("denominator",3,f1.denominator)
    }

    @Test
    void testRandomFrac() {
        FractionNumber f = FractionNumber.createRandom(10,9,10)
        assertTrue("whole $f.properWhole",10>f.properWhole)
        assertTrue("properNumerator",11>f.properNumerator)
        assertTrue("denominator",12>f.denominator)


        FractionNumber f1 = FractionNumber.createRandomInteger(10,9)
        assertTrue("whole $f1.properWhole",10>=f1.properWhole)
        assertTrue("whole $f1.properWhole",f1.properWhole>=9)
        assertTrue("properNumerator",0 == f1.properNumerator)

    }

    @Test
    void testPlusMinus() {
        FractionNumber f1 = new FractionNumber(1,1,2)
        FractionNumber f2 = new FractionNumber(1,1,2)
        FractionNumber r1 = f1+f2
        FractionNumber r2 = f1-f2

        assertEquals("whole",3,r1.properWhole)
        assertEquals("properNumerator",0,r1.properNumerator)

        assertEquals("whole",0,r2.properWhole)
        assertEquals("properNumerator",0,r2.properNumerator)
    }

    @Test
    void testFractionProperties() {
        FractionNumber f1 = new FractionNumber(-1,1,2)
        FractionNumber f2 = new FractionNumber(1,-1,2)
        FractionNumber f3 = new FractionNumber(0,1,2)
        FractionNumber f4 = new FractionNumber(0,-1,2)
        FractionNumber f5 = new FractionNumber(1,1,2)

        assertTrue("negative whole",f1.negative)
        assertTrue("negative numerator",f2.negative)
        assertTrue("less than one whole",f3.lessThanOne())
        assertTrue("less than one whole, negative numerator",f4.lessThanOne())
        assertFalse(f5.negative)
        assertFalse(f5.lessThanOne())
    }


}

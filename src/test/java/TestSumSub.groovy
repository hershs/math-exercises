import org.bernshtam.matex.PartsFraction
import org.junit.Test

import static org.junit.Assert.assertEquals
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
        PartsFraction f = new PartsFraction(1,14,6)
        assertEquals("whole",3,f.properWhole)
        assertEquals("properNumerator",2,f.properNumerator)
        assertEquals("denominator",6,f.denominator)

        PartsFraction f1 = f.reduce()
        assertEquals("whole",3,f1.properWhole)
        assertEquals("properNumerator",1,f1.properNumerator)
        assertEquals("denominator",3,f1.denominator)
    }

    @Test
    void testRandomFrac() {
        PartsFraction f = PartsFraction.createRandom(10,9,10)
        assertTrue("whole",10>f.properWhole)
        assertTrue("properNumerator",11>f.properNumerator)
        assertTrue("denominator",12>f.denominator)
    }

    @Test
    void testPlusMinus() {
        PartsFraction f1 = new PartsFraction(1,1,2)
        PartsFraction f2 = new PartsFraction(1,1,2)
        PartsFraction r1 = f1+f2
        PartsFraction r2 = f1-f2

        assertEquals("whole",3,r1.properWhole)
        assertEquals("properNumerator",0,r1.properNumerator)

        assertEquals("whole",0,r2.properWhole)
        assertEquals("properNumerator",0,r2.properNumerator)

    }
}

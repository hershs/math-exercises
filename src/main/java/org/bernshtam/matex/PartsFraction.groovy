package org.bernshtam.matex

import org.apache.commons.lang3.math.Fraction

import java.awt.image.renderable.RenderableImage



/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/18/12
 * Time: 10:26 PM
 */
class PartsFraction implements Renderable {

    private static Random r = new Random(System.currentTimeMillis())
    static PartsFraction createRandom(int intpartmax, int numMax, int denMax) {
        return new PartsFraction(r.nextInt(intpartmax), r.nextInt(numMax)+1, r.nextInt(denMax)+2)
    }

    static PartsFraction createRandom(int intpartmax,  int denMax) {
        def den = r.nextInt(denMax-1)+2
        def num = r.nextInt(den-1)+1
        def whole = r.nextInt(intpartmax+1)
        return new PartsFraction(whole, num, den)
    }

    static PartsFraction createRandomInteger(int intpartmax, int intpartmin) {
        def whole = r.nextInt(intpartmax-intpartmin)+intpartmin
        return new PartsFraction(whole, 0, 1)
    }

    Fraction f



    PartsFraction(Fraction f) {
        this.f = f
    }
    PartsFraction(int num, int den) {
        f =  Fraction.getFraction(num,den)
    }
    PartsFraction(int intpart, int num, int den) {
        f = Fraction.getFraction(intpart*den+num, den)
    }



    boolean printInt() { return f.properWhole!=0}
    boolean printFrac() { return f.properNumerator!=0}



    PartsFraction plus(PartsFraction f) {
        return new PartsFraction(this.f.add(f.f))
    }

   PartsFraction multiply(PartsFraction f) {
        return new PartsFraction(this.f.multiplyBy(f.f))
    }

   PartsFraction div(PartsFraction f) {
        return new PartsFraction(this.f.divideBy(f.f))
    }

    PartsFraction minus(PartsFraction f) {
        return new PartsFraction(this.f.subtract(f.f))
    }

    int getProperNumerator() {
        return this.f.properNumerator
    }



    int getProperWhole() {
        return f.properWhole
    }

    int getDenominator() {
        return f.denominator
    }

    int getNumerator() {
        return f.numerator
    }

    PartsFraction reduce() {
        return new PartsFraction(f.reduce())
    }

    String toString() {
        return f.properWhole+" "+ f.properNumerator +"/" + f.denominator
    }


}

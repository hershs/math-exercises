package org.bernshtam.matex

import com.google.code.twig.ObjectDatastoreFactory
import com.google.code.twig.annotation.Child
import com.google.code.twig.annotation.Entity
import com.google.code.twig.annotation.Id
import org.apache.commons.lang3.math.Fraction

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/18/12
 * Time: 10:26 PM
 */

class FractionNumber implements Renderable, Computable {

    private static Random r = new Random(System.currentTimeMillis())

    static FractionNumber createRandom(int intpartmax, int numMax, int denMax) {
        return new FractionNumber(r.nextInt(intpartmax), r.nextInt(numMax) + 1, r.nextInt(denMax) + 2)
    }

    static FractionNumber createRandom(int intpartmax, int denMax) {
        def den = r.nextInt(denMax - 1) + 2
        def num = r.nextInt(den - 1) + 1
        def whole = r.nextInt(intpartmax + 1)
        return new FractionNumber(whole, num, den)
    }

    static FractionNumber createRandomInteger(int intpartmax, int intpartmin) {
        def whole = r.nextInt(intpartmax - intpartmin) + intpartmin
        return new FractionNumber(whole, 0, 1)
    }



    Fraction f
    @Id long id

    FractionNumber() {
    }

    FractionNumber(Fraction f) {
        this.f = f
    }

    FractionNumber(int num, int den) {
        f = Fraction.getFraction(num, den)
    }

    FractionNumber(int intpart, int num, int den) {
        f = Fraction.getFraction(
                nonZeroSign(intpart) * nonZeroSign(num) *
                        (Math.abs(intpart) * den + Math.abs(num)),
                den)
    }



    boolean printInt() { return f.properWhole != 0 }

    boolean printFrac() { return f.properNumerator != 0 }



    FractionNumber plus(FractionNumber f) {
        return new FractionNumber(this.f.add(f.f))
    }

    FractionNumber multiply(FractionNumber f) {
        return new FractionNumber(this.f.multiplyBy(f.f))
    }

    FractionNumber div(FractionNumber f) {
        return new FractionNumber(this.f.divideBy(f.f))
    }

    FractionNumber minus(FractionNumber f) {
        return new FractionNumber(this.f.subtract(f.f))
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

    FractionNumber reduce() {
        return new FractionNumber(f.reduce())
    }

    String toString() {
        return f.properWhole + " " + f.properNumerator + "/" + f.denominator
    }

    @Override
    FractionNumber compute() {
        return this
    }

    boolean isNegative() {
        return numerator < 0
    }

    boolean lessThanOne() {
        return properWhole == 0
    }

    double value() {
        return f.doubleValue()
    }

    static int nonZeroSign(int i) {
        return i < 0 ? -1 : 1
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof FractionNumber)) return false

        FractionNumber that = (FractionNumber) o

        if (f != that.f) return false

        return true
    }

    int hashCode() {
        return f.hashCode()
    }
}

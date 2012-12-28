package org.bernshtam.matex

import com.google.code.twig.ObjectDatastoreFactory
import com.google.code.twig.annotation.Child
import com.google.code.twig.annotation.Entity
import com.google.code.twig.annotation.Id
import org.apache.commons.lang3.math.Fraction
import org.bernshtam.matex.util.FactorUtils

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

    static FractionNumber createDecimalRandom(int intpartmax) {
        def number = new FractionNumber(r.nextInt(intpartmax), r.nextInt(9) + 1, random10())
        number.decimal = true
        return number
    }

    static def GOOD_NUMBERS = [1, 2, 4, 5, 8]

    static int goodRandomNumber() {
        return GOOD_NUMBERS[r.nextInt(GOOD_NUMBERS.size())]
    }

    static FractionNumber createGoodDivDecimalRandom(FractionNumber dividend) {
        int n = dividend.numerator
        int m = FactorUtils.getRandomFactor(n)
        def number = new FractionNumber(m, 10)
        number.decimal = true
        return number
    }

    static FractionNumber createGoodDecimalRandom(int intpartmax) {
        int goodInt = FactorUtils.getGoodInt(intpartmax * 100)

        def number = new FractionNumber(goodInt, 100)
        number.decimal = true
        return number
    }

    static FractionNumber createGoodIntegerRandom(int max, int min) {
        int goodInt = FactorUtils.getGoodInt(max, min)

        def number = new FractionNumber(goodInt,0,1)

        return number
    }

    static FractionNumber createGoodDivIntegerRandom(FractionNumber dividend) {
        int n = dividend.properWhole
        int m = FactorUtils.getRandomFactor(n)
        def number = new FractionNumber(m)
        return number
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
    boolean decimal = false

    FractionNumber() {
    }

    FractionNumber(Fraction f) {
        this.f = f
    }

    FractionNumber(int num, int den) {
        f = Fraction.getFraction(num, den)
    }

    FractionNumber(double d) {
        f = Fraction.getFraction(d)
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

package org.bernshtam.matex

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 10:52 PM
 */
class RandomFormulaFactory {

    private static Random r = new Random(System.currentTimeMillis())

    FractionFormula createManyRandomIntegerFormula(int maxint, int minint, def signs, int m) {
        FractionFormula formula

        while (true) {

            boolean needGoodDiv = false

            def integer
            def f = []
            def s = []
            for (int i = 0; i < m - 1; i++) {
                if (needGoodDiv)
                    integer = FractionNumber.createGoodDivIntegerRandom(f[-1])
                else
                    integer = FractionNumber.createGoodIntegerRandom(maxint, minint)
                f << integer

                def sign;
                if (needGoodDiv && signs.size()>1) {
                    sign = Sign.random(signs - '-')
                } else {
                    sign = Sign.random(signs)
                }

                s << sign

                if (sign == Sign.DIV)
                    needGoodDiv = true
                else
                    needGoodDiv = false
            }

             if (needGoodDiv)
                    integer = FractionNumber.createGoodDivIntegerRandom(f[-1])
                else
                    integer = FractionNumber.createGoodIntegerRandom(maxint, minint)
                f << integer

            formula = new FractionFormula(f, s)

            FractionNumber res
            try { res = formula.compute() }
            catch (ArithmeticException e) { continue }

            if (!res.negative && res.value() != 0) {
                break
            }
        }

        return formula
    }

    FractionFormula createManyRandomDecimalFormula(int maxWhole, def signs, int m) {

        FractionFormula formula

        while (true) {

            boolean needGoodDiv = false


            def decimal
            def f = []
            def s = []
            for (int i = 0; i < m - 1; i++) {

                if (needGoodDiv)
                    decimal = FractionNumber.createGoodDivDecimalRandom(f[-1])
                else
                    decimal = FractionNumber.createGoodDecimalRandom(maxWhole)
                f << decimal

                def sign = Sign.random(signs)
                s << sign

                if (sign == Sign.DIV)
                    needGoodDiv = true
                else
                    needGoodDiv = false
            }

            if (needGoodDiv)
                decimal = FractionNumber.createGoodDivDecimalRandom(f[-1])
            else
                decimal = FractionNumber.createGoodDecimalRandom(maxWhole)
            f << decimal

            formula = new FractionFormula(f, s)

            FractionNumber res

            try { res = formula.compute() }
            catch (ArithmeticException e) { continue }

            if (!res.negative && res.value() != 0) {
                break
            }

        }

        return formula
    }

    FractionFormula createManyRandomFractionFormula(int maxWhole, int maxDenom, def signs, int m) {

        FractionFormula formula

        while (true) {

            def f = []
            def s = []
            for (int i = 0; i < m - 1; i++) {
                f << FractionNumber.createRandom(maxWhole, maxDenom)
                s << Sign.random(signs)
            }
            f << FractionNumber.createRandom(maxWhole, maxDenom)


            formula = new FractionFormula(f, s)

            FractionNumber res

            try { res = formula.compute() }
            catch (ArithmeticException e) { continue }

            if (!res.negative && res.value() != 0) {
                break
            }
        }

        return formula
    }
}

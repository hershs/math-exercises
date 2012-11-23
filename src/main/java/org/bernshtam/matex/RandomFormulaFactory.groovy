package org.bernshtam.matex

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 10:52 PM
 */
class RandomFormulaFactory {

    private static Random r = new Random(System.currentTimeMillis())

    FractionFormula createRandom2FractionFormula(int maxWhole, int maxDenom, String sign) {

        FractionFormula formula
        while (true) {
            FractionNumber f1 = FractionNumber.createRandom(maxWhole, maxDenom)
            FractionNumber f2 = FractionNumber.createRandom(maxWhole, maxDenom)

            formula = new FractionFormula(f1, f2, Sign.fromString(sign))


            FractionNumber res = formula.compute()
            if (!res.negative && res.value() != 0) {
                break
            }
        }

        return formula

    }

    FractionFormula createRandom3FractionFormula(int maxWhole, int maxDenom) {

        FractionFormula formula
        while (true) {
            FractionNumber f1 = FractionNumber.createRandom(maxWhole, maxDenom)
            FractionNumber f2 = FractionNumber.createRandom(maxWhole, maxDenom)
            FractionNumber f3 = FractionNumber.createRandom(maxWhole, maxDenom)

            formula = new FractionFormula(f1, f2, f3, Sign.random(), Sign.random())

            FractionNumber res
            try {  res = formula.compute() }
            catch (ArithmeticException e) { continue }


            if (!res.negative && res.value() != 0) {
                break
            }
        }

        return formula

    }

    FractionFormula create2RandomIntegerFormula(int max, int min, String sign, boolean withremainder) {

        FractionFormula formula

        while (true) {
            FractionNumber f1
            FractionNumber f2
            if (sign != ":") {
                f1 = FractionNumber.createRandomInteger(max, min)
                f2 = FractionNumber.createRandomInteger(max, min)
            } else if (withremainder) {
                f1 = FractionNumber.createRandomInteger(max, 2 * min)
                f2 = FractionNumber.createRandomInteger((int) f1.properWhole, min)
            } else {
                f2 = FractionNumber.createRandomInteger(max, min)
                f1 = new FractionNumber((2 + r.nextInt(8)) * f2.properWhole, 0, 1)
            }

            formula = new FractionFormula(f1, f2, Sign.fromString(sign))

            FractionNumber res
            try {  res = formula.compute() }
            catch (ArithmeticException e) { continue }



            if (!res.negative && !res.lessThanOne() && res.value() != 0) {
                break;
            }
        }




        return formula
    }

    FractionFormula create3RandomIntegerFormula(int max, int min) {

        FractionFormula formula

        while (true) {

            FractionNumber f1 = FractionNumber.createRandomInteger(max, min)
            FractionNumber f2 = FractionNumber.createRandomInteger(max, min)
            FractionNumber f3 = FractionNumber.createRandomInteger(max, min)


            formula = new FractionFormula(f1, f2, f3, Sign.randomExceptDiv(), Sign.random())

            FractionNumber res
            try {  res = formula.compute() }
            catch (ArithmeticException e) { continue }



            if (!res.negative && res.properNumerator == 0 && res.value() != 0) {
                break;
            }
        }




        return formula
    }

    FractionFormula createManyRandomIntegerFormula(int maxint, int minint, String[] signs, int m) {
        FractionFormula formula

        while (true) {

            def f = []
            def s = []
            for (int i = 0; i < m - 1; i++) {
                f << FractionNumber.createRandomInteger(maxint, minint)
                s << Sign.random(signs)
            }
            f << FractionNumber.createRandomInteger(maxint, minint)

            formula = new FractionFormula(f, s)

            FractionNumber res
             try {  res = formula.compute() }
            catch (ArithmeticException e) { continue }



            if (!res.negative && res.value() != 0) {
                break
            }
        }




        return formula
    }

    FractionFormula createManyRandomFractionFormula(int maxWhole, int maxDenom, String[] signs, int m) {

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

            try {  res = formula.compute() }
            catch (ArithmeticException e) { continue }

            if (!res.negative && res.value() != 0) {
                break
            }
        }

        return formula
    }
}

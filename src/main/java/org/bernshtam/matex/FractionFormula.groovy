package org.bernshtam.matex

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/19/12
 * Time: 9:12 AM
 */
class FractionFormula implements Renderable {

    private static Random r = new Random(System.currentTimeMillis())

    List<PartsFraction> fractions = []
    List<String> signs = []
    PartsFraction res

    static FractionFormula createRandomFractionFormula(int maxWhole, int maxDenom, String sign) {
        FractionFormula formula = new FractionFormula()

        PartsFraction f1
        PartsFraction f2
        f1 = PartsFraction.createRandom(maxWhole, maxDenom)
        f2 = PartsFraction.createRandom(maxWhole, maxDenom)


        PartsFraction res

        switch (sign) {
            case "+": res = f1 + f2; break;
            case "-": res = f1 - f2;
                if (res.numerator < 0) {
                    def t = f1; f1 = f2; f2 = t; res = f1 - f2
                };
                break;
            case "*": res = f1 * f2; break;
            case ":": res = f1 / f2; break;
            default: throw new Exception("Undefined op $sign")
        }


        formula.fractions << f1
        formula.fractions << f2
        formula.signs << sign
        formula.res = res.reduce()

        return formula

    }

    static FractionFormula createRandomIntegerFormula(int max, int min, String sign, boolean withremainder) {
        FractionFormula formula = new FractionFormula()

        PartsFraction f1
        PartsFraction f2
        if (sign != ":") {
            f1 = PartsFraction.createRandomInteger(max, min)
            f2 = PartsFraction.createRandomInteger(max, min)
        } else if (withremainder) {
            f1 = PartsFraction.createRandomInteger(max, 2*min)
            f2 = PartsFraction.createRandomInteger((int)f1.properWhole, min)
        } else {
            f2 = PartsFraction.createRandomInteger(max, min)
            f1 = new PartsFraction((2 + r.nextInt(8)) * f2.properWhole, 0, 1)
        }

        PartsFraction res

        switch (sign) {
            case "+": res = f1 + f2; break;
            case "-": res = f1 - f2;
                if (res.numerator < 0) {
                    def t = f1; f1 = f2; f2 = t; res = f1 - f2
                };
                break;
            case "*": res = f1 * f2; break;
            case ":": res = f1 / f2;
                if (res.properWhole < 1) {
                    def t = f1; f1 = f2; f2 = t; res = f1 / f2
                };
                break;
            default: throw new Exception("Undefined op $sign")
        }


        formula.fractions << f1
        formula.fractions << f2
        formula.signs << sign
        formula.res = res.reduce()

        return formula

    }
}

package org.bernshtam.matex
/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/19/12
 * Time: 9:12 AM
 */
class FractionFormula extends BaseComputable {

    private static Random r = new Random(System.currentTimeMillis())

    List<BaseComputable> computables = []
    List<Sign> signs = []

    FractionFormula(List<BaseComputable> computables, List<Sign> signs) {
        this.computables = computables
        this.signs = signs
    }

    FractionFormula(Computable f1, Computable f2, Sign sign) {
        computables<<f1
        computables<<f2
        signs<<sign
    }

    FractionFormula(Computable f1, Computable f2, Computable f3, Sign sign1, Sign sign2) {
        computables<<f1
        computables<<f2
        computables<<f3
        signs<<sign1
        signs<<sign2
    }



    @Override
    FractionNumber compute() {
        List<BaseComputable> c = computables.clone() as List<BaseComputable>
        List<Sign> s = signs.clone() as List<Sign>

        while(s.size() > 0 ) {
            Sign max = s.max{ it.ordinal()}
            int imax = s.indexOf(max)
            FractionNumber computable = compute(c[imax], c[imax+1], s[imax])
            s.remove(imax)
            c.remove(imax+1)
            c[imax] = computable
        }

        return c[0]
    }

    static FractionNumber compute(Computable f1, Computable f2, Sign sign) {
        FractionNumber res
        switch (sign) {
            case Sign.PLUS: res = f1 + f2; break;
            case Sign.MINUS: res = f1 - f2; break;
            case Sign.MULT: res = f1 * f2; break;
            case Sign.DIV: res = f1 / f2; break;
            default: throw new Exception("Undefined op $sign")
        }

        return res
    }


}

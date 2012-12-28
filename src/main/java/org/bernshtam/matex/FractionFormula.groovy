package org.bernshtam.matex

import com.google.code.twig.ObjectDatastoreFactory
import com.google.code.twig.annotation.Child
import com.google.code.twig.annotation.Entity
import com.google.code.twig.annotation.Id

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/19/12
 * Time: 9:12 AM
 */
class FractionFormula extends BaseComputable {


    List<BaseComputable> computables = []
    List<Sign> signs = []
    @Id long id

    FractionFormula() {
    }

    FractionFormula(List<BaseComputable> computables, List<Sign> signs) {
        this.computables = computables
        this.signs = signs
    }

    FractionFormula(Computable f1, Computable f2, Sign sign) {
        computables << f1
        computables << f2
        signs << sign
    }

    FractionFormula(Computable f1, Computable f2, Computable f3, Sign sign1, Sign sign2) {
        computables << f1
        computables << f2
        computables << f3
        signs << sign1
        signs << sign2
    }



    @Override
    FractionNumber compute() {
        List<BaseComputable> c = computables.clone() as List<BaseComputable>
        List<Sign> s = signs.clone() as List<Sign>

        while (s.size() > 0) {
            Sign max = s.max { it.ordinal()}
            int imax = s.indexOf(max)
            FractionNumber computable = compute(c[imax], c[imax + 1], s[imax])
            s.remove(imax)
            c.remove(imax + 1)
            c[imax] = computable
        }

        c[0].decimal = decimal
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
        res.decimal = f1.decimal && f2.decimal
        return res
    }

    @Override
    boolean isDecimal() {
        boolean decimal = true
        computables.each {decimal &= it.decimal}
        return decimal
    }

    @Override
    void setDecimal(boolean c) {

    }


}

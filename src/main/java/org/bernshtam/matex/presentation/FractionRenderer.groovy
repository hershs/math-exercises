package org.bernshtam.matex.presentation

import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.PartsFraction
import org.bernshtam.matex.Renderable
import org.bernshtam.matex.Renderer

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/20/12
 * Time: 9:35 PM
 */
class FractionRenderer implements Renderer {


    static String WHOLE_CLASS = "whole"
    static String FRAC_CLASS = "frac"

    String render(Renderable r) {
        if (!r instanceof PartsFraction) {
            throw new RuntimeException("Can render only fraction, received $r")
        }
        PartsFraction t = r as PartsFraction
        StringBuilder builder = new StringBuilder()
        if (t.printInt())
            builder.append("<span class='${WHOLE_CLASS}'>${t.properWhole}</span>\n")
        if (t.printFrac()) {
            builder.append("<span class='${FRAC_CLASS}'><sup>${t.properNumerator}</sup>\n")
            builder.append("<span>/</span>\n")
            builder.append("<sub> ${t.denominator} </sub></span>\n")
        }
        return builder.toString()
    }
}

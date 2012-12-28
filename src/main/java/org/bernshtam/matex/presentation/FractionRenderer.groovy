package org.bernshtam.matex.presentation

import org.bernshtam.matex.FractionNumber
import org.bernshtam.matex.Renderable
import org.bernshtam.matex.Renderer

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/20/12
 * Time: 9:35 PM
 */
class FractionRenderer implements Renderer {


    String render(PresentationFactory factory, Renderable r) {
        if (!r instanceof FractionNumber) {
            throw new RuntimeException("Can render only fraction, received $r")
        }
        FractionNumber t = r as FractionNumber
        StringBuilder builder = new StringBuilder()
        if (t.decimal) {
            builder.append("<span class='${WHOLE_CLASS}'>${t.value()}</span>\n")
        } else {
            if (t.printInt())
                builder.append("<span class='${WHOLE_CLASS}'>${t.properWhole}</span>\n")
            if (t.printFrac()) {
                builder.append("<span class='${FRAC_CLASS}'><sup>${t.properNumerator}</sup>\n")
                builder.append("<span>/</span>\n")
                builder.append("<sub> ${t.denominator} </sub></span>\n")
            }
        }
        return builder.toString()
    }
}

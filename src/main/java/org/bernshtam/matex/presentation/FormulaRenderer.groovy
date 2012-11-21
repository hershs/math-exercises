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
class FormulaRenderer implements Renderer {

    final Renderer fractionRenderer
    static RESULT_CLASS = "result"

    FormulaRenderer(Renderer fractionRenderer) {
        this.fractionRenderer = fractionRenderer
    }

    String render(Renderable r) {
        if (! r instanceof FractionFormula) {
            throw new RuntimeException("Can render only formulas, received $r")
        }
        FractionFormula t = r as FractionFormula
        StringBuilder builder = new StringBuilder()
        List<PartsFraction> fractions = t.fractions
        List<String> signs = t.signs
        for(int i=0;i<fractions.size()-1;i++) {
            builder.append(fractionRenderer.render(fractions[i]))
            builder.append("<span class='${FractionRenderer.WHOLE_CLASS}'> ${signs[i]} </span>")
        }
        builder.append(fractionRenderer.render(fractions[fractions.size()-1]))
        builder.append("<span class='${FractionRenderer.WHOLE_CLASS}'> = </span>")
        builder.append("<span class='$RESULT_CLASS'>${fractionRenderer.render(t.res)}</span>")
        return builder.toString()
    }
}

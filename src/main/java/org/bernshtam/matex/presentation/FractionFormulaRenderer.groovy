package org.bernshtam.matex.presentation

import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.Renderable
import org.bernshtam.matex.Renderer

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/20/12
 * Time: 9:35 PM
 */
class FractionFormulaRenderer implements Renderer {


    FractionFormulaRenderer(Renderer fractionRenderer) {

    }

    String render(PresentationFactory factory, Renderable r) {
        if (!r instanceof FractionFormula) {
            throw new RuntimeException("Can render only formulas, received $r")
        }
        FractionFormula t = r as FractionFormula
        StringBuilder builder = new StringBuilder()
        for(int i=0;i<t.signs.size();i++) {
            builder.append(factory.render(t.computables[i]))
            builder.append(factory.render(t.signs[i]))
        }
        builder.append(factory.render(t.computables[t.signs.size()]))
        builder.append("<span class='${WHOLE_CLASS}'> = </span>")
        builder.append("<span class='$RESULT_CLASS'> ${factory.render(t.compute())} </span>")
        return builder.toString()
    }


}

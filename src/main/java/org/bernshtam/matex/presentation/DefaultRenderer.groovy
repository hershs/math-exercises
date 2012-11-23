package org.bernshtam.matex.presentation

import org.bernshtam.matex.Renderable
import org.bernshtam.matex.Renderer

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 10:02 PM
 */
class DefaultRenderer implements Renderer {
    @Override
    String render(PresentationFactory factory, Renderable r) {
        return "<span class='${WHOLE_CLASS}'> ${r.toString()} </span>"
    }

}

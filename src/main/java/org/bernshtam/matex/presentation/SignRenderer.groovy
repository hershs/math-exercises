package org.bernshtam.matex.presentation

import org.bernshtam.matex.Renderable
import org.bernshtam.matex.Renderer
import org.bernshtam.matex.Sign

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 10:02 PM
 */
class SignRenderer implements Renderer {
    @Override
    String render(PresentationFactory factory, Renderable r) {
        if (!r instanceof Sign) {
            throw new RuntimeException("Can render only sign, received $r")
        }

        Sign s = r as Sign

        return "<span class='${WHOLE_CLASS}'> ${replace(s.sign)} </span>"
    }

    static String replace(String s) {
        switch (s) {
            case "*": "&times;"; break
//            case ":": "&divide;"; break
            default: s
        }
    }
}

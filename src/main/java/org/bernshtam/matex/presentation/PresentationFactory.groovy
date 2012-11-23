package org.bernshtam.matex.presentation

import org.bernshtam.matex.Renderable

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 9:52 PM
 */
interface PresentationFactory {
    String render(Renderable r)
}

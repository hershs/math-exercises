package org.bernshtam.matex

import org.bernshtam.matex.presentation.PresentationFactory


/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/20/12
 * Time: 9:39 PM
 */
public interface Renderer {
    static String WHOLE_CLASS = "whole"
    static String FRAC_CLASS = "frac"
    static RESULT_CLASS = "result"

    String render(PresentationFactory factory, Renderable r)
}
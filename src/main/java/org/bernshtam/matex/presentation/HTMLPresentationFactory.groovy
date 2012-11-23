package org.bernshtam.matex.presentation

import org.bernshtam.matex.*

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 9:53 PM
 */
class HTMLPresentationFactory implements PresentationFactory {

    Map<Class, Renderer> renderers = [:]

    HTMLPresentationFactory() {
        renderers[FractionNumber.class] = new FractionRenderer()
        renderers[FractionFormula.class] = new FractionFormulaRenderer()
        renderers[Sign.class] = new SignRenderer()
        renderers[Object.class] = new DefaultRenderer()

    }

    @Override
    String render(Renderable r) {
        def clazz = r.getClass()
        Renderer renderer = renderers[clazz]

        while (renderer == null) {
            clazz = clazz.getSuperclass()
            renderer = renderers[clazz]
        }

        return renderer.render(this,r)
    }
}

package org.bernshtam.matex.geom

import org.bernshtam.matex.geom.shapes.Piramide
import org.bernshtam.matex.geom.shapes.ThreeJsShape

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:08 PM
 */
class PiramideShapeCreator extends ShapeCreator {

    @Override
    ThreeJsShape create(int sceneSize) {
        return new Piramide(random(3,7),moreless(sceneSize/2),moreless(sceneSize*0.75));
    }
}

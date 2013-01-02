package org.bernshtam.matex.geom

import org.bernshtam.matex.geom.shapes.Icosahedron
import org.bernshtam.matex.geom.shapes.ThreeJsShape

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:08 PM
 */
class IcosahedronShapeCreator extends ShapeCreator {

    @Override
    ThreeJsShape create(int sceneSize) {

        return new Icosahedron(moreless(sceneSize/2),random(1,2))
    }
}

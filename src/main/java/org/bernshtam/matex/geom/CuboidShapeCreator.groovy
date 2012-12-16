package org.bernshtam.matex.geom

import org.bernshtam.matex.geom.shapes.Cuboid
import org.bernshtam.matex.geom.shapes.Piramide
import org.bernshtam.matex.geom.shapes.ThreeJsShape

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:08 PM
 */
class CuboidShapeCreator extends ShapeCreator {

    @Override
    ThreeJsShape create(int sceneSize) {
        return new Cuboid(moreless(sceneSize/2),moreless(sceneSize/2),moreless(sceneSize*0.75));
    }
}

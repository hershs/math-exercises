package org.bernshtam.matex.geom

import org.bernshtam.matex.geom.shapes.Cube
import org.bernshtam.matex.geom.shapes.ThreeJsShape

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:08 PM
 */
class CubeShapeCreator extends ShapeCreator {

    @Override
    ThreeJsShape create(int sceneSize) {

        return new Cube(moreless(sceneSize/2));
    }
}

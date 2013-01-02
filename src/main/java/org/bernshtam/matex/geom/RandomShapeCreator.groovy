package org.bernshtam.matex.geom

import org.bernshtam.matex.geom.shapes.ThreeJsShape

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:07 PM
 */
public interface RandomShapeCreator {
    ThreeJsShape create(int sceneSize)
}
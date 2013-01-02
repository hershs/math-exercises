package org.bernshtam.matex.geom

import org.bernshtam.matex.geom.shapes.ThreeJsShape

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:15 PM
 */
abstract class LevelShapeCreator extends ShapeCreator {
    def creators

    LevelShapeCreator(creators) {
        this.creators = creators
    }

    LevelShapeCreator() {
    }

    @Override
    ThreeJsShape create(int sceneSize) {
        return creators[random(0,creators.size())].create(sceneSize)
    }
}

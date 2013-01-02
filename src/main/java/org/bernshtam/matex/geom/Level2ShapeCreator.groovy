package org.bernshtam.matex.geom

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:15 PM
 */
class Level2ShapeCreator extends LevelShapeCreator {
    Level2ShapeCreator() {
        creators = [
                new IcosahedronShapeCreator(),
                new OctahedronShapeCreator(),
                new TetrahedronShapeCreator(),
                new CubeShapeCreator()

        ]
    }
}

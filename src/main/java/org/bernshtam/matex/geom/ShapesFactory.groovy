package org.bernshtam.matex.geom

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/10/12
 * Time: 10:55 PM
 */
class ShapesFactory {
    private static ShapeCreator shapeCreator = new Level1ShapeCreator()

    static def getShapes() {
        def shapes = []
        30.times { shapes << shapeCreator.create(180)}
        return shapes
    }
}

package org.bernshtam.matex.geom

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:15 PM
 */
class Level1ShapeCreator extends LevelShapeCreator {
    Level1ShapeCreator() {
        creators = [
                new PrismaShapeCreator(),
                new PiramideShapeCreator(),
                new Level2ShapeCreator()
        ]
    }
}

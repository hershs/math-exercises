package org.bernshtam.matex.geom.shapes

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 3:38 PM
 */
abstract class ThreeJsShape {

    double yRotation = -0.7
    //int xPosition, yPosition, zPosition

    final String name

    ThreeJsShape(String name) {
        this.name = name
    }

    abstract String getJsConstructor()
}

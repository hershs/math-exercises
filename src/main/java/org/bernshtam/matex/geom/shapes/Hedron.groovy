package org.bernshtam.matex.geom.shapes

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:01 PM
 */
abstract class Hedron extends ThreeJsShape {
    int radius;
    int subdivisions

    Hedron(String name,int radius, int subdivisions) {
        super(name)
        this.radius = radius
        this.subdivisions = subdivisions
    }

    @Override
    String getJsConstructor() {
        return "new THREE.${this.class.getSimpleName()}Geometry( $radius, $subdivisions )"
    }
}

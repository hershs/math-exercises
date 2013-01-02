package org.bernshtam.matex.geom.shapes

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 3:48 PM
 */
class Cuboid extends ThreeJsShape {

    int x,y,z
    Cuboid(int x, int y, int z) {
        this("Cuboid",x,y,z)
    }

    Cuboid(String name, int x, int y, int z) {
        super(name)
        this.x = x
        this.y = y
        this.z = z
    }

    @Override
    String getJsConstructor() {
        return "new THREE.CubeGeometry($x, $y, $z)"
    }
}

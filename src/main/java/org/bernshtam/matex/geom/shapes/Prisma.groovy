package org.bernshtam.matex.geom.shapes

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 3:48 PM
 */
class Prisma extends ThreeJsShape {

    int num,radius,height

    Prisma(int num, int radius, int height) {
        this("Prisma",num,radius,height)
        if (num == 4) yRotation=0.5
    }

    Prisma(String name, int num, int radius, int height) {
        super(name)
        this.num = num
        this.radius = radius
        this.height = height

    }

    @Override
    String getJsConstructor() {
        return "new THREE.CylinderGeometry($radius, $radius, $height, $num, 1, true)"
    }
}

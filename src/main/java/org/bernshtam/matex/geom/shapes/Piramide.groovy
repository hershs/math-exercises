package org.bernshtam.matex.geom.shapes

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 3:48 PM
 */
class Piramide extends Prisma {



    Piramide(int num, int radius, int height) {
        super("Piramide",num,radius,height)
        if (num == 4) yRotation=0.5
        if (num == 3) yRotation=0.2
    }


    @Override
    String getJsConstructor() {
        return "new THREE.CylinderGeometry(0, $radius, $height, $num, 1, true)"
    }
}

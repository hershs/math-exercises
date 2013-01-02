package org.bernshtam.matex.geom

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/11/12
 * Time: 4:08 PM
 */
abstract class ShapeCreator implements RandomShapeCreator {
    private Random r = new Random(System.currentTimeMillis())

    protected int random(int from, int to) {
        return r.nextInt(to-from)+from
    }

    protected int moreless(int i, double percent) {
        def min = (int) i+(1-percent);
        def max = (int) i*(1+percent);
        return r.nextInt(max-min)+min
    }

    protected int moreless(int i) {
        return moreless(i,0.3)
    }

    protected int moreless(double i) {
        return moreless((int)i,0.5)
    }
}

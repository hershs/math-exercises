package org.bernshtam.matex.util

/**
 * Created by IntelliJ IDEA.
 * User: pavelber
 * Date: 12/27/12
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
class FactorUtils {

    private static Random r = new Random(System.currentTimeMillis())



    static int getGoodInt(int maxint) {
        return getGoodInt(maxint,1 )
    }
    static int getGoodInt(int maxint, int minint) {
        if (maxint < 5)
            return maxint


        while (true) {
            int n = r.nextInt(maxint - minint - 5) + 5+minint
            Set factors = factors(n)

            if (factors.size() > 2) {
                return n
            }
        }
    }

    static def factors(int n) {
        def  factors =[];
        factors.add(n);
        factors.add(1);
        for (int test = n - 1; test >= Math.sqrt(n); test--)
            if (n % test == 0) {
                factors.add(test);
                factors.add((int) (n / test));
            }
        return factors;
    }

    static int getRandomFactor(int n) {

        def factors = factors(n)

        if (factors.size()>2) {
            factors = factors - 1
            factors = factors - n
        }
        def object = factors[r.nextInt(factors.size())]

        return object
    }
}

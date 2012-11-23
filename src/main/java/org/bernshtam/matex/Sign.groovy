package org.bernshtam.matex

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 10:00 PM
 */
enum Sign implements Renderable {


    PLUS("+"),
    MINUS("-"),
    MULT("*"),
    DIV(":")

    private static Random r = new Random(System.currentTimeMillis())

    String sign


    private Sign(String sign) {
        this.sign = sign
    }

    static Sign fromString(String s) {
        switch (s) {
            case '+': return PLUS;
            case '-': return MINUS;
            case '*': return MULT;
            case ':': return DIV;
            default: throw new Exception("Undefined op $s")
        }
    }

    static Sign random() {
        return  Sign.enumConstants[r.nextInt(Sign.enumConstants.length)]
    }

    static Sign random(String [] possible) {
        return  Sign.fromString(possible[r.nextInt(possible.length)])
    }

    static Sign randomExceptDiv() {
        Sign s
        while (( s = random())==DIV);
        return s
    }
}

package org.bernshtam.matex

import com.google.code.twig.ObjectDatastoreFactory
import groovyx.gaelyk.datastore.Entity

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/21/12
 * Time: 10:00 PM
 */
@com.google.code.twig.annotation.Entity
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

    static Sign random(def possible) {
        return  Sign.fromString(possible[r.nextInt(possible.size())])
    }

    static Sign randomExceptDiv() {
        Sign s
        while (( s = random())==DIV);
        return s
    }

    static def stringValues() {
        Sign[] v = values()
        def sv = []
        v.each { sv << it.sign}

        return sv
    }


}

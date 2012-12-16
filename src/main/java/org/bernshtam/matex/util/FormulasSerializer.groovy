package org.bernshtam.matex.util

import org.bernshtam.matex.FractionFormula

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/28/12
 * Time: 11:03 PM
 */
public interface FormulasSerializer {
    String serialize(List<FractionFormula> f)
    List<FractionFormula> deserialize(String s)
}
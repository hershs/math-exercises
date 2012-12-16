package org.bernshtam.matex.util

import com.thoughtworks.xstream.XStream
import org.bernshtam.matex.FractionFormula

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/28/12
 * Time: 11:04 PM
 */
class XStreamSerializer implements FormulasSerializer{

    private final XStreamGae xstream = new XStreamGae();

    XStreamSerializer() {
        xstream.registerConverter(new SignConverter())
    }

    @Override
    String serialize(List<FractionFormula> f) {
        return xstream.toXML(f);
    }

    @Override
    List<FractionFormula> deserialize(String s) {
        return xstream.fromXML(s) as List<FractionFormula>
    }
}

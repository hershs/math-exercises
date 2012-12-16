package org.bernshtam.matex.util

import com.thoughtworks.xstream.converters.Converter
import com.thoughtworks.xstream.converters.MarshallingContext
import com.thoughtworks.xstream.converters.UnmarshallingContext
import com.thoughtworks.xstream.io.HierarchicalStreamReader
import com.thoughtworks.xstream.io.HierarchicalStreamWriter
import org.bernshtam.matex.Sign

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/3/12
 * Time: 9:55 PM
 */
class SignConverter implements Converter{
    @Override
    void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Sign s = o as Sign
        hierarchicalStreamWriter.startNode("sign")
        hierarchicalStreamWriter.setValue(s.getSign())
        hierarchicalStreamWriter.endNode()
    }

    @Override
    Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Sign s
        hierarchicalStreamReader.moveDown()
        s = Sign.fromString(hierarchicalStreamReader.getValue())
        hierarchicalStreamReader.moveUp()
        return s
    }

    @Override
    boolean canConvert(Class aClass) {
        return aClass == Sign.class
    }
}

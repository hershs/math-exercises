package org.bernshtam.matex.servlets

import com.google.code.twig.ObjectDatastoreFactory
import org.apache.commons.lang3.math.Fraction
import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.FractionNumber
import org.bernshtam.matex.SavedExercise

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/10/12
 * Time: 10:33 AM
 */
class InitServlet extends HttpServlet {
    @Override
    void init() throws ServletException {
        super.init()
        ObjectDatastoreFactory.register(FractionNumber.class);
        ObjectDatastoreFactory.register(FractionFormula.class);
        ObjectDatastoreFactory.register(SavedExercise.class);
        ObjectDatastoreFactory.register(Fraction.class);


    }
}

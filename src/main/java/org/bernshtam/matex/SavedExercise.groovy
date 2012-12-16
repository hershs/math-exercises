package org.bernshtam.matex

import com.google.code.twig.ObjectDatastoreFactory
import com.google.code.twig.annotation.Child
import com.google.code.twig.annotation.Entity
import com.google.code.twig.annotation.Id

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 11/27/12
 * Time: 7:31 PM
 */

class SavedExercise {


    String login
    String name
    //String serializable
    List<FractionFormula> formulas
    @Id long id
}

import com.google.code.twig.ObjectDatastore
import com.google.code.twig.annotation.AnnotationObjectDatastore
import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.SavedExercise
import org.bernshtam.matex.util.XStreamSerializer

String name = request.getParameter("name")
String serialized  = request.getParameter("value")
List<FractionFormula> formuls = new XStreamSerializer().deserialize(serialized)


SavedExercise exercise = new SavedExercise(login: user.email, name: name,formulas: formuls )

ObjectDatastore datastoring = new AnnotationObjectDatastore();

datastoring.store(exercise)

forward "/listsaved.groovy"
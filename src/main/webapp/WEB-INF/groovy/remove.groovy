import com.google.code.twig.ObjectDatastore
import com.google.code.twig.annotation.AnnotationObjectDatastore
import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.SavedExercise
import org.bernshtam.matex.util.XStreamSerializer

Long id = Long.parseLong(request.getParameter("id"))

ObjectDatastore datastoring = new AnnotationObjectDatastore();

SavedExercise exercise = datastoring.load(SavedExercise.class,id)
datastoring.delete(exercise)

forward "listsaved.groovy"
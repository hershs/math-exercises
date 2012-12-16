import com.google.code.twig.ObjectDatastore
import com.google.code.twig.annotation.AnnotationObjectDatastore
import org.bernshtam.matex.SavedExercise
import static   com.google.appengine.api.datastore.Query.FilterOperator.*

def email = user.email

ObjectDatastore datastoring = new AnnotationObjectDatastore();

Iterator<SavedExercise> exerciseIterator =  datastoring.find().type(SavedExercise.class).addSort("name").addFilter("login", EQUAL, email).now()

def exercises = []

while(exerciseIterator.hasNext()) {
    exercises << exerciseIterator.next()
}


request['exercises'] = exercises
forward "exercises.gtpl"
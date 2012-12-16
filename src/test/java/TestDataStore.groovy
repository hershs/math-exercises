import com.google.appengine.api.datastore.QueryResultIterator
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig
import com.google.appengine.tools.development.testing.LocalServiceTestHelper
import com.google.code.twig.ObjectDatastore
import com.google.code.twig.ObjectDatastoreFactory
import com.google.code.twig.annotation.AnnotationObjectDatastore
import org.apache.commons.lang3.math.Fraction
import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.FractionNumber
import org.bernshtam.matex.SavedExercise
import org.bernshtam.matex.Sign
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import static org.junit.Assert.*

import static   com.google.appengine.api.datastore.Query.FilterOperator.*

/**
 * Created with IntelliJ IDEA.
 * User: pavelber
 * Date: 12/4/12
 * Time: 9:48 PM
 */
class TestDataStore {
    private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @BeforeClass
    static void register() {
        ObjectDatastoreFactory.register(FractionNumber.class);
        ObjectDatastoreFactory.register(FractionFormula.class);
        ObjectDatastoreFactory.register(SavedExercise.class);
        ObjectDatastoreFactory.register(Fraction.class);
    }
    @Test
    void testExercide() {

        ObjectDatastore datastoring = new AnnotationObjectDatastore();


        FractionNumber  number1 = FractionNumber.createRandom(2,5)
        FractionNumber  number2 = FractionNumber.createRandom(2,5)
        FractionFormula formula = new FractionFormula(number1, number2,Sign.fromString('+'))

        def email = "a@a.com"
        SavedExercise exercise = new SavedExercise(login: email, name: "aaa",formulas: [formula] )

        datastoring.store(exercise)


        Iterator<SavedExercise> exerciseIterator =  datastoring.find().type(SavedExercise.class).addSort("name").addFilter("login", EQUAL, email).now();

        assertEquals(exercise, exerciseIterator.next())

    }

    @Test
    void testFraction() {


        ObjectDatastore datastoring = new AnnotationObjectDatastore();

        FractionNumber  number = FractionNumber.createRandom(2,5)

        datastoring.store(number)
    }

    @Test
    void testFrormula() {

        ObjectDatastore datastoring = new AnnotationObjectDatastore();

        FractionNumber  number1 = FractionNumber.createRandom(2,5)
        FractionNumber  number2 = FractionNumber.createRandom(2,5)
        FractionFormula formula = new FractionFormula(number1, number2,Sign.fromString('+'))

        datastoring.store(formula)
    }
}

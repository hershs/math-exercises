import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.RandomFormulaFactory

int n = 10
int m = 3

int maxWhole = 6
int maxDen = 7

Random r = new Random(System.currentTimeMillis())

def exercises = []
String signsString = request.getParameter("signs")
def signs = signsString.split(",")

// Optional params
String nStr =   request.getParameter("n")
if (nStr!=null) {
    n = Integer.parseInt(nStr)
}

String mStr =   request.getParameter("m")
if (mStr!=null) {
    m = Integer.parseInt(mStr)
}

String maxWholeStr =   request.getParameter("maxwhole")
if (maxWholeStr!=null) {
    maxWhole = Integer.parseInt(maxWholeStr)
}

String maxDenStr =   request.getParameter("maxden")
if (maxDenStr!=null) {
    maxDen = Integer.parseInt(maxDenStr)
}

RandomFormulaFactory factory = new RandomFormulaFactory()

n.times {

    FractionFormula formula = factory.createManyRandomFractionFormula(maxWhole, maxDen, signs, m )
    exercises << formula
}

request['type'] = 'Fractions'
request['exercises'] = exercises
forward "exercise.gtpl"
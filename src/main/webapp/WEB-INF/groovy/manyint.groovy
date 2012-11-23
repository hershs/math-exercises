import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.RandomFormulaFactory

int n = 10
int m = 4
int maxWhole = 99
int minWhole = 10

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

String minWholeStr =   request.getParameter("minwhole")
if (minWholeStr!=null) {
    minWhole = Integer.parseInt(minWholeStr)
}

RandomFormulaFactory factory = new RandomFormulaFactory()

n.times {
    FractionFormula formula = factory.createManyRandomIntegerFormula(maxWhole, minWhole, signs, m)
    exercises << formula

}

request['exercises'] = exercises
forward "exercise.gtpl"
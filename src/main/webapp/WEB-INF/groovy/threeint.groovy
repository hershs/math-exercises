import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.RandomFormulaFactory

int n = 10
int maxWhole = 99
int minWhole = 10

Random r = new Random(System.currentTimeMillis())

def exercises = []



// Optional params
String nStr =   request.getParameter("n")
if (nStr!=null) {
    n = Integer.parseInt(nStr)
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
    FractionFormula formula = factory.create3RandomIntegerFormula(maxWhole, minWhole)
    exercises << formula

}

request['exercises'] = exercises
forward "exercise.gtpl"
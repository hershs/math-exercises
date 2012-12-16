import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.RandomFormulaFactory

int n = 10
int maxWhole = 99
int minWhole = 10

Random r = new Random(System.currentTimeMillis())

def exercises = []
String signsString = request.getParameter("signs")
def signs = signsString.split(",")

boolean reminder = request.getParameter("reminder") == "yes"


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
    String sign = signs[r.nextInt(signs.length)]
    FractionFormula formula = factory.create2RandomIntegerFormula(maxWhole, minWhole, sign, reminder)
    exercises << formula

}

request['type'] = 'Integers'
request['exercises'] = exercises
forward "exercise.gtpl"
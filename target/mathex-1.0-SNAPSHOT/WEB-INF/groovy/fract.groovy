import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.PartsFraction

int n = 10
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

String maxWholeStr =   request.getParameter("maxwhole")
if (maxWholeStr!=null) {
    maxWhole = Integer.parseInt(maxWholeStr)
}

String maxDenStr =   request.getParameter("maxden")
if (maxDenStr!=null) {
    maxDen = Integer.parseInt(maxDenStr)
}


n.times {

    String sign = signs[r.nextInt(signs.length)]
    FractionFormula formula = FractionFormula.createRandomFractionFormula(maxWhole, maxDen, sign)
    exercises << formula
}

request['exercises'] = exercises
forward "exercise.gtpl"
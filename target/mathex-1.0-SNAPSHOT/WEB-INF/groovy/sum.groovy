import org.bernshtam.matex.FractionFormula
import org.bernshtam.matex.PartsFraction

int n = 10

Random r = new Random(System.currentTimeMillis())

def exercises = []
String signsString = request.getParameter("signs")
def signs = signsString.split(",")


n.times {


    String sign = signs[r.nextInt(signs.length)]
    FractionFormula formula = FractionFormula.createRandomFractionFormula(6, 7, sign)
    exercises << formula

}

request['exercises'] = exercises
forward "exercise.gtpl"
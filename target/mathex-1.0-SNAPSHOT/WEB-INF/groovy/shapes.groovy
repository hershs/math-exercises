import org.bernshtam.matex.geom.*

int n = Integer.parseInt(request.getParameter('n'))
def types = request.getParameterValues('shapetype')

def creators = []

if (types.contains('Cube')) creators << new CubeShapeCreator()
if (types.contains('Cuboid')) creators << new CuboidShapeCreator()
if (types.contains('Piramid')) creators << new PiramideShapeCreator()
if (types.contains('Prism')) creators << new PrismaShapeCreator()
if (types.contains('Icosahedron')) creators << new IcosahedronShapeCreator()
if (types.contains('Octahedron')) creators << new OctahedronShapeCreator()
if (types.contains('Tetrahedron')) creators << new TetrahedronShapeCreator()

ShapeCreator creator = new ListShapeCreator(creators)

def shapes = []
if (creators.size() > 0) {
    n.times {
        shapes << creator.create(180)
    }
}

request['shapes'] = shapes
forward "shapes.gtpl"
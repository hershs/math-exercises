<% include '/WEB-INF/includes/header.gtpl' %>
<H3>Create your own fractions exercise</H3>
<p>
<form name="customShapesForm" action="shapes.groovy" method="post">
Number of shapes: <input name="n" id="n" type="number" value="10" min="1" max="30"/><br/><br/>
Include shapes types:
    <blockquote>
        <input type="checkbox" name="shapetype" value="Cube"> Cube<br>
        <input type="checkbox" name="shapetype" value="Cuboid"> Cuboid<br>
        <input type="checkbox" name="shapetype"  checked="checked" value="Piramid"> Piramid<br>
        <input type="checkbox" name="shapetype" value="Prism"> Prism<br>
        <input type="checkbox" name="shapetype" value="Icosahedron"> Icosahedron<br>
        <input type="checkbox" name="shapetype" value="Octahedron"> Octahedron<br>
        <input type="checkbox" name="shapetype" value="Tetrahedron"> Tetrahedron<br>
    </blockquote>

<br/><br/>

<input type="submit" value=" Generate " /></form>
</p>
<% include '/WEB-INF/includes/footer.gtpl' %>


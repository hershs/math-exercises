<% include '/WEB-INF/includes/header.gtpl' %>
<H3>${i18n.custom_shapes_title}</H3>
<p>
<form name="customShapesForm" action="shapes.groovy" method="post">
${i18n.custom_num_shapes} <input name="n" id="n" type="number" value="10" min="1" max="30"/><br/><br/>
${i18n.custom_shapes_types}
    <blockquote>
        <input type="checkbox" name="shapetype" value="Cube"> ${i18n.shapes_cube}<br>
        <input type="checkbox" name="shapetype" value="Cuboid"> ${i18n.shapes_cuboid}<br>
        <input type="checkbox" name="shapetype"  checked="checked" value="Piramid"> ${i18n.shapes_piramid}<br>
        <input type="checkbox" name="shapetype" value="Prism"> ${i18n.shapes_prism}<br>
        <input type="checkbox" name="shapetype" value="Icosahedron"> ${i18n.shapes_icosahedron}<br>
        <input type="checkbox" name="shapetype" value="Octahedron"> ${i18n.shapes_octahedron}<br>
        <input type="checkbox" name="shapetype" value="Tetrahedron"> ${i18n.shapes_tetrahedron}<br>
    </blockquote>

<br/><br/>

<input type="submit" value=" ${i18n.generate} " /></form>
</p>
<% include '/WEB-INF/includes/footer.gtpl' %>


<% import org.bernshtam.matex.* %>
<% import org.bernshtam.matex.geom.shapes.* %>
<% import org.bernshtam.matex.geom.shapes.shapes.* %>
<% import org.bernshtam.matex.util.* %>
<% import java.text.* %>
<% import org.bernshtam.matex.presentation.* %>

<% include '/WEB-INF/includes/header.gtpl' %>



<div class="yesPrint">

    <%
        def shapes = request['shapes']
        int num = shapes.size()
    %>

    <% for(int i=0;i<num;i++) { %>
    <div id="id_${i}" class="shape" ></div>
    <% } %>


</div>
<script>

    var CANVAS_WIDTH = 400,  CANVAS_HEIGHT = 400;


    <% for(int i=0;i<num;i++) { %>

    // -----------------------------------------------
    var container${i} = document.getElementById('id_${i}');
    var main = document.getElementById('main');

    main.appendChild(container${i});

    var renderer${i} = new THREE.WebGLRenderer({antialias: true,  preserveDrawingBuffer: true });
    renderer${i}.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    container${i}.appendChild(renderer${i}.domElement);

    var scene${i} = new THREE.Scene();

    //camera${i} = new THREE.PerspectiveCamera(70, 0.5, 0.1, 1000);
    camera${i} = new THREE.OrthographicCamera( CANVAS_WIDTH / - 2,CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_HEIGHT / - 2, -2000, 1000 );
    camera${i}.position.y = CANVAS_WIDTH*0.75;
    camera${i}.position.z = CANVAS_WIDTH*2;
    camera${i}.lookAt(scene${i}.position);
    scene${i}.add(camera${i});

    var shape${i} = new THREE.Mesh(
            ${shapes[i].jsConstructor} ,
            new THREE.MeshBasicMaterial({ color: 0x000000, wireframe: true, transparent: true }
            ));
    shape${i}.rotation.y =   ${shapes[i].yRotation};
    scene${i}.add(shape${i});



    <% } %>

    render();

    // -----------------------------------------------
    function render() {

        <% for(int i=0;i<num;i++) { %>
        renderer${i}.render(scene${i}, camera${i});
        <% } %>


    }



</script>
<% include '/WEB-INF/includes/footer.gtpl' %>


<% import org.bernshtam.matex.* %>
<% import org.bernshtam.matex.presentation.* %>

<% include '/WEB-INF/includes/header.gtpl' %>

<p class="noPrint">
<a href='#' class="resulter" style="margin-right:50px">Show/hide results</a>
<a href='#' class="printer1" style="margin-right:50px">Print with results</a>
<a href='#' class="printer2" style="margin-right:50px">Print without results</a>
</p>


<% PresentationFactory r = new HTMLPresentationFactory() %>

<div class="yesPrint">
<% request.exercises.each { formula -> %>
    <p>
       ${r.render(formula)}
    </p>
<% } %>
</div>

<% include '/WEB-INF/includes/footer.gtpl' %>


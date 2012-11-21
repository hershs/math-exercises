<% import org.bernshtam.matex.* %>
<% import org.bernshtam.matex.presentation.* %>

<% include '/WEB-INF/includes/header.gtpl' %>

<p class="noPrint"><a href='#' class="resulter" style="margin-right:50px">Show/hide results</a>  <a href='#' class="printer">Print</a> </p>


<% FormulaRenderer r = new FormulaRenderer(new FractionRenderer()) %>

<div class="yesPrint">
<% request.exercises.each { formula -> %>
    <p>
       ${r.render(formula)}
    </p>
<% } %>
</div>

<% include '/WEB-INF/includes/footer.gtpl' %>


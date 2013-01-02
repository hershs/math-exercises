<% import org.bernshtam.matex.* %>
<% import org.bernshtam.matex.util.* %>
<% import java.text.* %>
<% import org.bernshtam.matex.presentation.* %>

<% include '/WEB-INF/includes/header.gtpl' %>

<p class="noPrint">
 <%  if (request['name']) {%>
     <span  style="margin-right:50px">${request['name']}</span>
<% } %>
<a href='#' class="resulter" style="margin-right:50px"> ${i18n.exercise_showhide}</a>
<a href='#' class="printer1" style="margin-right:50px"> ${i18n.exercise_print_with}</a>
<a href='#' class="printer2" style="margin-right:50px"> ${i18n.exercise_print_without}</a>
<% if (user && !request['name']) { %>
    <form name="saveExercise" action="save" method="post">
    <input type="submit" value="  ${i18n.exercise_save} " />  ${i18n.exercise_under}
    <input id="name" name="name" type="text" value="${request['type']} Exercise ${DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date())}" size='30'/>
    <input id="value" name="value" type="text" value='${new XStreamSerializer().serialize(request.exercises)}' hidden="true"/>
    </form>

<% } %>
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


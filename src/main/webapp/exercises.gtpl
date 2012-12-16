<% include '/WEB-INF/includes/header.gtpl' %>

<h2>Saved exercises</h2>
<table  cellpadding="30">


<% request.exercises.each { ex -> %>
    <tr><td align="right"  style="padding-right: 30px"><A HREF="load?id=${ex.id}"> ${ex.name}</A> </td><td align="right"><A HREF="remove?id=${ex.id}"> (X)</A> </td></tr>
<% } %>
</table>

<% include '/WEB-INF/includes/footer.gtpl' %>


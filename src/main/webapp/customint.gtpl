<% include '/WEB-INF/includes/header.gtpl' %>
<H3>Create your own integers exercise</H3>
<p>

<form name="customFracForm" action="int.groovy" method="post">
Number of exercises: <input name="n" id="n" type="number" value="10" min="1" max="99"/><br/><br/>
Operations: <select name="signs" id="signs">
<option value="+">+</option>
<option value="+,/">+,/</option>
<option value="-">-</option>
<option value="*">*</option>
<option value="*,/">*,/</option>
<option value="/">/</option>
<option value="+,-,*,/">+,-,*,/</option>
</select>
<br/><br/>
Maximum integer value: <input id="maxwhole" name="maxwhole" type="number" value="99" min="2" max="9999"/><br/><br/>                                                                                   <br/>
Minimum integer value: <input id="minwhole" name="minwhole" type="number" value="10" min="2" max="99"/><br/><br/>                                                                                   <br/>
<input type="submit" value="SUBMIT" /></form>
</p>
<% include '/WEB-INF/includes/footer.gtpl' %>


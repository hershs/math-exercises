<% include '/WEB-INF/includes/header.gtpl' %>
<H3>Create your own fractions exercise</H3>
<p>
<form name="manyFracForm" action="manyfract.groovy" method="post">
Number of exercises: <input name="n" id="n" type="number" value="10" min="1" max="99"/><br/><br/>
Number of fractions: <input name="m" id="m" type="number" value="3" min="2" max="5"/><br/> <br/>
Operations: <select name="signs" id="signs">
<option value="+">+</option>
<option value="+,-">+,-</option>
<option value="-">-</option>
<option value="*">&times;</option>
<option value="*,:">*,:</option>
<option value=":">:</option>
<option value="+,-,*,:">+,-,&times;,:</option>
</select>
<br/><br/>
Maximum whole part: <input id="maxwhole" name="maxwhole" type="number" value="6" min="0" max="9"/><br/><br/>                                                                                   <br/>
Maximum denominator: <input id="maxden" name="maxden" type="number" value="7" min="2" max="20"/><br/><br/>                                                                                   <br/>
<input type="submit" value=" Generate " /></form>
</p>
<% include '/WEB-INF/includes/footer.gtpl' %>


<% include '/WEB-INF/includes/header.gtpl' %>
<H3>${i18n.custom_integers_title}</H3>

<p>

<blockquote>
    <form name="manyIntForm" action="manyint.groovy" method="post">

        ${i18n.custom_num_exercises} <input name="n" id="n" type="number" value="10" min="1" max="99"/><br/> <br/>
        ${i18n.custom_num_exercises} <input name="m" id="m" type="number" value="3" min="2" max="5"/><br/><br/>
        ${i18n.custom_operations} <select name="signs" id="signs">
        <option value="+">+</option>
        <option value="+,-">+,-</option>
        <option value="*">&times;</option>
        <option value="*,:">&times;,:</option>
        <option value="+,-,*">+,-,&times;</option>
    </select>
        <br/><br/>
        ${i18n.custom_max_int} <input id="maxwhole" name="maxwhole" type="number" value="99" min="2"
                                      max="9999"/><br/><br/>
        ${i18n.custom_min_int} <input id="minwhole" name="minwhole" type="number" value="10" min="2"
                                      max="99"/><br/><br/>
        <input type="submit" value=" ${i18n.generate} "/></form>
</blockquote>
</p>
<% include '/WEB-INF/includes/footer.gtpl' %>


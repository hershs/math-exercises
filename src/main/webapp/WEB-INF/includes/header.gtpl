<html>
<head>
    <title>Math exercises generator</title>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <link rel="shortcut icon" href="/images/note-favicon.png" type="image/png">
    <link rel="icon" href="/images/note-favicon.png" type="image/png">

    <link rel="stylesheet" type="text/css" href="/css/main.css.gtpl"/>

    <style media="screen">
        .noPrint {
            display: block;
        }

        .main {
            display: block !important;
        }
    </style>
    <style media="print">
        .left {
            display: none;
        }

        .header {
            display: none;
        }

        .noPrint {
            display: none;
        }

        .main {
            display: block !important;
        }
    </style>

    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="three.min.js"></script>
    <script type="text/javascript">

        var visible = false;

        \$(document).ready(function () {
            \$(".resulter").click(function () {
                if (!visible) {
                \$('.result').css({'visibility': 'visible'});
                }
                else {
                \$('.result').css({'visibility': 'hidden'});
                }
                visible = !visible;
            });

		        \$(".printer1").click(function () {
                \$('.result').css({'visibility': 'visible'});
                visible = true;
                window.print();
            });

                 \$(".printer2").click(function () {
                \$('.result').css({'visibility': 'hidden'});
                visible = false;
                window.print();
            });
        });

    </script>
</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<div id="container">
    <div id="header" class="noPrint">
        <h1><A HREF="/">${i18n.title}</A></h1>
        <h2>${i18n.title_description}</h2><br/>
        <A HREF="encoding.groovy?encoding=en">English</A> <A HREF="encoding.groovy?encoding=ru">Русский</A> <A HREF="encoding.groovy?encoding=he">עברית</A>
        <hr/>
    </div>
    <!-- end header -->

    <div id="left" class="noPrint" ">
        <div id="topmenu">
            <% if (!user) { %>
            <p><A href="${users.createLoginURL('/')}">${i18n.menu_login}</A></p>
            <% } else { %>
            <p><A href="/listsaved">${i18n.menu_exercises}</A> <br/></p>
            <p><A href="${users.createLogoutURL('/')}">${i18n.menu_logout}</A></p>
            <% } %>
        </div>

        <h3>${i18n.menu_fractions}</h3>
        <p>
            <A href="manyfract.groovy?signs=%2B&n=10&m=2&maxwhole=6&maxden=7">${i18n.menu_fractions} +</A><BR/>
            <A href="manyfract.groovy?signs=%2B,-&n=10&m=2&maxwhole=6&maxden=7">${i18n.menu_fractions} +/-</A> <BR/>
            <A href="manyfract.groovy?signs=%2A&n=10&m=2&maxwhole=6&maxden=7">${i18n.menu_fractions} &times;</A><BR/>
            <A href="manyfract.groovy?signs=:&n=10&m=2&maxwhole=6&maxden=7">${i18n.menu_fractions} &divide;</A><BR/>
            <A href="manyfract.gtpl">${i18n.menu_custom}</A><BR/>
        </p>
        <h3>${i18n.menu_integers}</h3>
        <p>
            <A href="manyint.groovy?signs=%2B&n=10&m=2&maxwhole=99&minwhole=10&maxden=7">${i18n.menu_integers} +</A><BR/>
            <A href="manyint.groovy?signs=%2B,-&n=10&m=2&maxwhole=99&minwhole=10&maxden=7">${i18n.menu_integers} +/-</A> <BR/>
            <A href="manyint.groovy?signs=%2A&n=10&m=2&maxwhole=99&minwhole=10&maxden=7">${i18n.menu_integers} &times;</A><BR/>
            <A href="manyint.groovy?signs=:&n=10&m=2&maxwhole=99&minwhole=10&maxden=7">${i18n.menu_integers} &divide;</A><BR/>
            <A href="manyint.gtpl">${i18n.menu_custom}</A><BR/>
        </p>
         <h3>${i18n.menu_decimals}</h3>
        <p>
            <A href="decimal.groovy?signs=%2B&n=10&m=2&maxwhole=10&maxden=7">${i18n.menu_decimals} +</A><BR/>
            <A href="decimal.groovy?signs=%2B,-&n=10&m=2&maxwhole=10&maxden=7">${i18n.menu_decimals} +/-</A> <BR/>
            <A href="decimal.groovy?signs=%2A&n=10&m=2&maxwhole=10&maxden=7">${i18n.menu_decimals} &times;</A><BR/>
            <A href="decimal.groovy?signs=:&n=10&m=2&maxwhole=10&maxden=7">${i18n.menu_decimals} &divide;</A><BR/>
            <A href="decimal.gtpl">${i18n.menu_custom}</A><BR/>
        </p>


        <p>
            <A href="customshapes.gtpl"><h3>${i18n.menu_shapes}</h3></A><BR/>
        </p>
        <p>
            ${i18n.menu_donate}

        <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
            <input type="hidden" name="cmd" value="_s-xclick">
            <input type="hidden" name="hosted_button_id" value="JJAAS8JNV4CKL">
            <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donate_SM.gif" border="0"
                   name="submit" alt="PayPal - The safer, easier way to pay online!">
            <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
        </form>
        </p>
        <p>
        <div class="fb-like" data-href="http://math-exercises.appspot.com/" data-send="false" data-layout="button_count" data-width="450" data-show-faces="false"></div>
        </p>
        </div>
    <!-- end left division -->

    <div id="main">
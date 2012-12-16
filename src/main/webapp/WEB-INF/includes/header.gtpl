<html>
<head>
    <title>Math exercises generator</title>

    <link rel="shortcut icon" href="/images/note-favicon.png" type="image/png">
    <link rel="icon" href="/images/note-favicon.png" type="image/png">

    <link rel="stylesheet" type="text/css" href="/css/main.css"/>

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
        <h1><A HREF="/">Math exercises generator</A></h1>
        <h2>Generate math exercises for your children and check answers</h2><br/>
        <hr/>
    </div>
    <!-- end header -->

    <div id="left" class="noPrint">
        <div id="topmenu">
            <% if (!user) { %>
            <p><A href="${users.createLoginURL('/')}">Login</A></p>
            <% } else { %>
            <p><A href="/listsaved">My Exercises</A> <br/></p>
            <p><A href="${users.createLogoutURL('/')}">Logout</A></p>
            <% } %>
        </div>

        <h3>2 Fractions</h3>
        <p>
            <A href="fract.groovy?signs=%2B">Fractions +</A><BR/>
            <A href="fract.groovy?signs=%2B,-">Fractions +/-</A> <BR/>
            <A href="fract.groovy?signs=%2A">Fractions &times;</A><BR/>
            <A href="fract.groovy?signs=:">Fractions &divide;</A><BR/>
            <A href="customfrac.gtpl">Custom fractions</A><BR/>
        </p>
        <h3>2 Integers</h3>
        <p>
            <A href="int.groovy?signs=%2B">Integers +</A><BR/>
            <A href="int.groovy?signs=%2B,-">Integers +/-</A> <BR/>
            <A href="int.groovy?signs=%2A">Integers &times;</A><BR/>
            <A href="int.groovy?signs=:">Integers &divide;</A><BR/>
            <A href="customint.gtpl">Custom integers</A><BR/>
        </p>
        <p>
            <A href="threefract.groovy">3 Fractions</A><BR/>
            <A href="threeint.groovy">3 Integers</A><BR/>
        </p>
        <p>
            <A href="manyfract.gtpl">Many fractions</A><BR/>
            <A href="manyint.gtpl">Many integers</A><BR/>
        </p>
        <p>
            <A href="customshapes.gtpl"><h3>Shapes</h3></A><BR/>
        </p>
        <p>
            Donate to keep this site working

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
body {
    font-family:arial, verdana, helvetica, sans-serif;
    font-size:12px;
    cursor:default;
    background-color:#FFFFFF
}
* {
    margin: 0px;
    padding: 0px;
    text-decoration: none;
}
html {
    height:100%;
    margin-bottom:1px;
}
#container {
    width: 95%;
    margin-right: auto;
    margin-${i18n.text_align}: auto;
    text-align: ${i18n.text_align};
    background-color: #FFFFFF;
}
#header {
    width:100%;
    padding-top:15px;
}
#topmenu {
    text-align: ${i18n.text_align};
    font-size: 15px;
    font-weight: bold;
    font-family: Helvetica, sans-serif;
    border: black, solid, 1px;
    border-radius: 5px;
    margin-top: 10px;
}
.spacer {
    width:100%;
    height:15px;
}
hr {
    border:0px;
    color:#CCCCCC;
    background-color:#CDCDCD;
    height: 1px;
    width: 100%;
    text-align: ${i18n.text_align};
}
h1 {
    font-size:28px;
    color:#cc0000;
    background-color:#FFFFFF;
    font-family:Arial, Verdana, Helvetica, sans-serif;
    font-weight:300;
}
h2 {
    font-size:15px;
    color:gray;
    font-family:Arial, Verdana, Helvetica, sans-serif;
    font-weight:300;
    background-color:#FFFFFF;
}
h3 {
    color:#cc0000;
    font-size:15px;
    text-align:${i18n.text_align};
    font-weight:300;
    padding:5px;
    margin-top:5px;
}

#left {
    float:${i18n.text_align};
    width:100px;
    background-color:#FFFFFF;
    color:black;
    direction:${i18n.direction};
}

#main {
    margin					: 5px ${i18n.right_margin} 5px ${i18n.left_margin};
    padding					: 15px;
    border-${i18n.text_align} : 1px solid silver;
    direction:${i18n.direction};
}
p {
    color:black;
    background-color:#FFFFFF;
    /*line-height:20px;*/
    padding:5px;
}
a {
    color:#cc0000;
    background-color:#FFFFFF;
    text-decoration:none;
}
a:hover {
    color:#cc0000;
    background-color:#FFFFFF;
    text-decoration:underline;
}
#footer {
    clear:both;
    font-size:12px;
    font-family:Verdana, Arial, Helvetica, sans-serif;
}
.right {
    color:gray;
    background-color:#FFFFFF;
    float:right;
    font-size:100%;
    margin-top:5px;
}
.left {
    color:gray;
    background-color:#FFFFFF;
    float:${i18n.text_align};
    font-size:100%;
    margin-top:5px;

}

span.frac {
    display: inline-block;
    /*font-size: 50%;*/
    text-align: center;
}
span.frac > sup {
    display: block;
    border-bottom: 1px solid;
    font: inherit;
}
span.frac > span {
    display: none;
}
span.frac > sub {
    display: block;
    font: inherit;
}

.whole {
    font-size: 200%;
}



.result {
    visibility: hidden;
}

.yesPrint {
    direction: ltr;
}
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library</title>


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <link rel="stylesheet" href="/temp/pagination.css" >
    <style>
    *{margin:0px; padding:0px;}
        body{ background:url(../background1.png); font-family: Helvetica, sans-serif; }
    h1 {  font-family: Helvetica, Arial, sans-serif;  text-align: center;
	  text-shadow: 2px 2px 0px rgba(255,255,255,.7), 5px 7px 0px rgba(0, 0, 0, 0.1);  font-size:50px; margin-top:60px; color:#fff;
}
#wrapper{ border: 5px solid rgba(255,255,255,0.6);  padding: 10px;  width:60%;  margin:60px auto; }
.contents div{text-align:center; color:#123; font-size:20px; margin:20px auto}
</style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/temp/pagination.js"></script>
    <script>
$(document).ready(function()
 {
   $("#tab").pagination({
   items: 5,
   contents: 'contents',
   previous: 'Previous',
   next: 'Next',
   position: 'bottom',
   });
});
</script>

</head>
<body>
<a href="/bookadd">Добавить книгу</a>
<a href="/">Библиотека</a>


<div class="container mt-5" >
    <h5>Welcom in library!</h5>
    <div id="wrapper">
        <div class="contents">

    <#list book as book>
        <div>

    ${book.name}
        ${book.author}
        ${book.description}

        </div>

            <#else>
    No messages
</#list>
    </div>
</div>
</div>

</body>
</html>


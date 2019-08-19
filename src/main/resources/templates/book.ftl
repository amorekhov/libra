<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library</title>


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <link rel="stylesheet" href="/temp/pagination.css" >

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
<div>
<div class="container mt-5" >
<a href="/bookadd">Добавить книгу</a>
<a href="/">Библиотека</a>
<a href="/orders">Take book</a>
<a href="/book/sortnameasc">Sort</a>

<div class="container mt-5" >
    <h5>Welcom in library!</h5>




    <div id="wrapper">
        <div class="contents">




    <#list book as book>

        <div >

            <b> <td >Name:  ${book.name}   </td></b>
            <i> <td >Author:   ${book.author}   </td></i>
            <td>Description:  ${book.description}   </td>

            <td> <a class="btn btn-primary" href="/book/take/${book.bookId}">Взять </a></td>
            <td> <a class="btn btn-primary" href="/book/edit/${book.bookId}">Изменить </a></td>
            <td> <a class="btn btn-primary" href="/book/del/${book.bookId}">удалить</a></td>


        </div>

            <#else>
    No messages
</#list>

    </div>
</div>

</div>
</div>
</body>
</html>


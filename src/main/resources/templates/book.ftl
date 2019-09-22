<#import "parts/login.ftl" as l>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library</title>


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <link rel="stylesheet" href="/temp/pagination.css">

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
    <div class="container mt-5">
        <div>
            <@l.logout />
        </div>
        <div>
            <a class="btn btn-primary" href="/bookadd">Добавить книгу</a>
            <a class="btn btn-primary" href="/">Библиотека</a>
            <a class="btn btn-primary" href="/orders">Take book</a>

        </div>
        <div>
            <a class="btn btn-primary" href="/book/sortnameasc">Sort name asc</a>
            <a class="btn btn-primary" href="/book/sortnamedesc">Sort name desk</a>
            <a class="btn btn-primary" href="/book/sortauthorasc">Sort author asc</a>
            <a class="btn btn-primary" href="/book/sortauthordesc">Sort author desc</a>

        </div>
        <div class="container mt-5">
            <h5>Welcom in library!</h5>


            <div id="wrapper">
                <div class="contents">


                    <#list book as book>

                    <div>

                        <b>
                            <td>Name: ${book.name}</td>
                        </b>
                        <i>
                            <td>Author: ${book.author}</td>
                        </i>
                        <td>Description: ${book.description}</td>
                        <td>
                            <#assign known = "${book.availability?c}"
                            user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
                            name = user.getUsername()
                            isCurrent=name>
                            <#if known=="true">
                            <a class="btn btn-primary" href="/book/take/${book.bookId}"> Взять
                            </a>
                        <td><a class="btn btn-primary" href="/book/del/${book.bookId}">удалить</a></td>
                        <#elseif isCurrent =="${book.user.username}">
                        <a class="btn btn-primary" href="/book/deltake/${book.bookId}"> Вернуть
                        </a>

                    </
                    #if>
                    </td>
                    <td><a class="btn btn-primary" href="/book/edit/${book.bookId}">Изменить </a></td>


                </div>

                <#else>
                No book
            </
            #list>

        </div>
    </div>

</div>
</div>
</body>
</html>


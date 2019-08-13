<#import "parts/common.ftl" as c>


<@c.page>




<h5>Welcom in library!</h5>
<a href="/bookadd">Добавить книгу</a>
<a href="/">Библиотека</a>

<div class="card-columns">

    <#list book as book>

    <form class="card my-3" style="width: 18rem;">
        Name <h3> ${book.name}</h3>
        Location <h3>${book.author}</h3>
        Description <h3> ${book.description}</h3>


        <div>
            <a class="btn btn-primary" href="/">Посмотреть тур</a>
        </div>
    </form>

    <#else>
    No messages
</#list>

</div>


</@c.page>
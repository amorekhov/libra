<#import "parts/common.ftl" as c>

<@c.page>
<#list book as book>
<div>

    <form  method="post" action="/bookadd">
        <div>
            <input type="text" name="name"  value="${book.name}"/>
        </div>
        <div>
            <input type="text" name = "author" value="${book.author}"/>
        </div>
        <div>
            <input type="text"  name="description"  />
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />


        <button type="submit">Submit</button>
    </form>
</div>
<#else>

</#list>

</@c.page>

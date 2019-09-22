<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<a class="btn btn-primary" href="/book">книги</a>
<#list book as book>
<div class="table">
    <#assign known = "${book.user!}"
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isCurrent=name>
    <#if known!="">
    Name: <b>${book.name}</b>

    User: <b> ${book.user.username!}</b>
    <#if isCurrent =="${book.user.username}"> <a class="btn btn-primary" href="/book/deltake/${book.bookId}">вернуть</a>
</#if>
</#if>
</div>
<#else>
No orders
</#list>

</@c.page>
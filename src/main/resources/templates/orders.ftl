<#import "parts/common.ftl" as c>


<@c.page>
   <a href="/book">книги</a>
<#list orders as orders>
    <div class="table">
    ${orders.ordersId}
    ${orders.book.name}
    ${orders.user.username}
   <a class="btn btn-primary" href="/orders/del/${orders.ordersId}">вернуть</a>
    </div>
        <#else>
No messages
</#list>

</@c.page>
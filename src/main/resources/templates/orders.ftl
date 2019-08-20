<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
   <a class="btn btn-primary" href="/book">книги</a>
<#list orders as orders>
    <div class="table">

        Name:  <b>${orders.book.name}</b>
        User:   <b>   ${orders.user.username}</b>
        <a class="btn btn-primary" href="/orders/del/${orders.ordersId}">вернуть</a>
    </div>
        <#else>
No orders
</#list>

</@c.page>
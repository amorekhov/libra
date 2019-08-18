<#import "parts/common.ftl" as c>


<@c.page>

<#list orders as orders>

    ${orders.ordersId}
    ${orders.book.name}
    ${orders.user.username}

<#else>
No messages
</#list>

</@c.page>
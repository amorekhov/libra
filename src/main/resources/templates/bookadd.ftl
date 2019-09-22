<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout />
</div>
<div>
    <form method="post" action="/bookadd">
        Name:
        <div>
            <input type="text" name="name"/>
        </div>
        Author:
        <div>
            <input type="text" name="author"/>
        </div>
        Description:
        <div>
            <input type="text" name="description"/>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>


        <button type="submit">Submit</button>
    </form>
</div>


</@c.page>

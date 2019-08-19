<#import "parts/common.ftl" as c>

<@c.page>

<div>

    <form  method="post" >
        <div>
            <input type="text" name="name"  value="${name}"/>
        </div>
        <div>
            <input type="text" name = "author" value="${author}"/>
        </div>
        <div>
            <input type="text"  name="description"  value="${description}" />
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />


        <button type="submit">Submit</button>
    </form>
</div>

</@c.page>

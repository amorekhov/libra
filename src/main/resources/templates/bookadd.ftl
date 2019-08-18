<#import "parts/common.ftl" as c>

<@c.page>

<div>
    <form  method="post" action="/bookadd">
        <div>
            <input type="text" name="name"  />
        </div>
        <div>
            <input type="text" name = "author" />
        </div>
        <div>
            <input type="text"  name="description"  />
        </div>
  <!--      <div>
            <input type="text"  name="countAll"  />
        </div>
-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />


        <button type="submit">Submit</button>
    </form>
</div>


</@c.page>

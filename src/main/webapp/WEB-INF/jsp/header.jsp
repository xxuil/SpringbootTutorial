<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <nav class="navbar navbar-default" role="navigation" style="background-color: white">
        <div class="container-fluid" style="margin-left: 10%">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">BBS</a>
            </div>
            <div>
                <c:if test="${empty userId}">
                    <!--未登陆-->
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <p class="navbar-text"><a href="/login">登录</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="/register">注册</a></p>
                        </li>
                    </ul>
                </c:if>
                <c:if test="${!empty userId}">
                    <!--已登陆-->
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <p class="navbar-text"><a href="/">首页</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="/member/${sessionScope.username}">${sessionScope.username}</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="/settings">设置</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="javascript:signout_confirm();">登出</a></p>
                        </li>
                    </ul>
                </c:if>
            </div>
        </div>
    </nav>


</header>
<script>
    function signout_confirm()
    {
        var r=confirm("确定退出?")
        if (r==true)
        {
            window.location.href="/logout";
        }
        else
        {

        }
    }
</script>
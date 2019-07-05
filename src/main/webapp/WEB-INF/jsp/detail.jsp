<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <title>${post.title} - BBS </title>
</head>
<body>
<!-- 引入header文件 -->
<%--<%@ include file="header.jsp"%>--%>
<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <div>
                <div class="panel-heading" style="background-color: white">
                    <a href="/">BBS</a> › 主题
                </div>
                <h3>${post.title}</h3><br/>
            </div>
        </div>

        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                ${post.content}
            </li>
        </ul>
    </div>

    <c:if test="${!empty replies}">
        <div class="panel panel-default" id="main" style="">
            <div class="panel-heading" style="background-color: white">
        <span>
                ${fn:length(replies)} 回复  |  直到 <c:forEach items="${replies}" var="reply" varStatus="status">

            <c:if test="${status.last}">
                ${reply.time}
            </c:if>
        </c:forEach>
    </span>
            </div>

            <ul class="list-group" style="width: 100%">
                <!-- 遍历评论 -->
                <c:forEach items="${replies}" var="reply">
                    <li class="list-group-item">
                        <div style="height: 50px">
                            <div style="width: 89%;float: left">
                                <a href="/member/${reply.userId}"><strong>${reply.userId}</strong></a>&nbsp;&nbsp;
                                <small class="text-muted">${reply.time}</small>
                                <br/>
                                <div>
                                    <p>${reply.content}</p>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>

            </ul>
        </div>
    </c:if>

    <c:if test="${!empty user}">

        <div class="panel panel-default" id="main" style="">
            <div class="panel-heading" style="background-color: white">
                添加一条新回复
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <form action="/reply/add" method="post">
                        <input type="hidden" name="postId" value="${post.pid}">
                        <input type="hidden" name="userId" value="${user.uid}">
                        <textarea class="form-control" rows="3" name="content" required="required"></textarea><br/>
                        <input type="submit" class="btn btn-default btn-sm" value="回复">
                    </form>
                </div>

            </div>
        </div>
    </c:if>

</div>
<!-- 引入侧边栏文件 -->
<%@ include file="side.jsp"%>

<!-- 引入footer文件 -->
<%@ include file="footer.jsp"%>

</body>
</html>
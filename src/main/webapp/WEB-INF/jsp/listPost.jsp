<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>pid</td>
            <td>title</td>
            <td>view</td>
            <td>reply</td>
            <td>edit</td>
        </tr>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.pid}</td>
                <td>${c.title}</td>
                <td>${c.viewCount}</td>
                <td>${c.replyCount}</td>
                <td><a href="getPost?lid=${c.pid}">edit</a> </td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="?start=0">首  页</a>

        <c:if test="${page.start-page.count>=0}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>

        <c:if test="${page.start-page.count<0}">
            <a href="javascript:void(0)">上一页</a>
        </c:if>

        <c:if test="${page.start+page.count<=page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>

        <c:if test="${page.start+page.count>page.last}">
            <a href="javascript:void(0)">下一页</a>
        </c:if>

        <a href="?start=${page.last}">末  页</a>
    </div>
<%--    <div style="text-align:center;margin-top:40px">--%>

<%--        <form method="post" action="addPost">--%>
<%--            title： <input name="title" value="" type="text"> <br><br>--%>
<%--            content： <input name="content" value="" type="text"> <br><br>--%>
<%--            <input type="submit" value="add">--%>
<%--        </form>--%>

<%--    </div>--%>
</div>

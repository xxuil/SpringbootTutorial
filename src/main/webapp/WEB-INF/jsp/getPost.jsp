<%--
  Created by IntelliJ IDEA.
  User: liuxx
  Date: 2019-06-17
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>阅读页面</title>
</head>
<body>
<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">

        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>lid</td>
                <td>title</td>
                <td>content</td>
            </tr>
            <c:out value="post">
                <tr>
                    <td>${post.pid}</td>
                    <td>${post.title}</td>
                    <td>${post.content}</td>
                    <td><a href="deletePost?lid=${post.pid}">delete</a> </td>
                </tr>
            </c:out>

        </table>
    </div>
</div>
</body>
</html>
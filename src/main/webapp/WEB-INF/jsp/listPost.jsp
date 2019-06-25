<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>title</td>
    </tr>
    <c:forEach items="${posts}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.title}</td>

        </tr>
    </c:forEach>
</table>
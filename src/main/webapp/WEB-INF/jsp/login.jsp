<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<form action = "<%request.getContextPath();%>/check" method="post">
    username:&nbsp;<input type="text" name="username"/><br/>
    password <input type="text" name="password"/><br/>
    <input type="submit" value="login"/>
    <input type="reset" value="reset"/>
</form>
</body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="Content-Type"  content="text/html;charset=utf-8">
    <meta name="keywords" content="BBS_test">
    <title>社区 </title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <style>
        li {list-style-type:none;}
        html, body {
            height: 100%;
            font-size: 14px;
            color: #525252;
            font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,"Microsoft Yahei","Hiragino Sans GB","WenQuanYi Micro Hei",sans-serif;
            background: #f0f2f5;
        }
        .footer {
            background-color: #fff;
            margin-top: 22px;
            margin-bottom: 22px;
            width: 100%;
            padding-top: 22px;
            color: #8A8A8A;
            display: block;
            height: 200px;
            border: 1px ;
            clear:both
        }

        .container {
            margin-right: 5%;
            margin-left: 5%;
            padding-left: 15px;
            padding-right: 15px;
            width: 40%;
            float: left;
        }
        .info {
            margin-right: 5%;
            width: 10%;
            float: left;
        }
        a{
            color: #8A8A8A;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="panel panel-default" id="main" style="width: 70%;margin:1% 2% 5% 5%;float: left;">

    <ul class="list-group" style="width: 100%">
        <c:forEach items="${posts}" var="post">
            <li class="list-group-item">
                <div style="height: 50px">
                    <div style="width: 89%;float: left">
                        <a href="/post/${post.pid}">${post.title}</a><br/>
                    </div>
                    <div style="width: 5%;float: right;text-align: center">
                        <span class="badge">${post.viewCount}</span>
                    </div>
                    <div style="width: 5%;float: right;text-align: center">
                        <span class="badge">${post.replyCount}</span>
                    </div>
                </div>
            </li>
        </c:forEach>

    </ul>

</div>

<!-- 引入侧边栏文件 -->
<%@ include file="side.jsp"%>

<!-- 引入footer文件 -->
<%@ include file="footer.jsp"%>
</body>
</html>
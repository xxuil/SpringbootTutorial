<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <title>创作新主题 › Genesis </title>
</head>
<body>
<!-- 引入header文件 -->
<%--<%@ include file="header.jsp"%>--%>

<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <a href="/">BBS</a> › 创作新主题
        </div>

        <div class="panel-body">
            <form action="/post/add" method="post" id="replyForm">
                <div class="form-group">
                    <label for="title">主题标题</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="请输入主题标题，如果标题能够表达完整内容，则正文可以为空" required="required">
                </div>
                <div class="form-group">
                    <label for="content">正文</label>
                    <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                </div>
                <input type="submit" class="btn btn-default btn-sm" value="发布主题">
            </form>
        </div>

    </div>



</div>

<!-- 引入footer文件 -->
<%@ include file="footer.jsp"%>

<script>
    function submitValidate(flag){
        return flag;
    }
    $("#replyForm").submit(function () {
        if($("#title").val()==''){
            alert("请填写标题！");
            return submitValidate(false);
        }else {
            var ifSubmit=confirm("确定发表该主题吗?");
            if (ifSubmit == true){

            }else {
                return submitValidate(false);
            }
        }
    })
</script>
</body>
</html>
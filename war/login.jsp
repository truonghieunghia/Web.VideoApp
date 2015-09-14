<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/login.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Administrator</title>
</head>
<body>
<div id="container">
        <form action="/login?<%=request.getQueryString() %>" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <div id="lower">
                <input type="checkbox"><label class="check" for="checkbox">Keep me logged in</label>
                <input type="submit" value="Login">
            </div>
        </form>
    </div>
</body>
</html>
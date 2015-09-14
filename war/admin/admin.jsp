<%@ include file="lib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/admin.css">
<script type="text/javascript" language="javascript" src="/js/ajax.js"></script>
<title>Administrator Video</title>
<script language="JavaScript">
    function changeBack(AppID){
      for (var i = 0; i < document.getElementById("AppID").options.length; i++) {
        if (document.getElementById("AppID").options[i].selected){
        	location.href = "?page=Pushs&key="+document.getElementById("AppID").options[i].value;
        }
      }
    }
    function changeAppID(AppID){
        for (var i = 0; i < document.getElementById("AppID").options.length; i++) {
          if (document.getElementById("AppID").options[i].selected){
          	location.href = "?page=Devices&fillter="+document.getElementById("AppID").options[i].value;
          }
        }
      }
    </script>
</head>
<body>
	<table border="1" height="100%">
		<tr>
			<td id="left_menu"><%@include file="admin_left.jsp"%>
			</td>

			<td id="content" width="100%" valign="top">
			<c:if test="${page == 0}">
				<%@include file="app.jsp"%>
			</c:if>
			<c:if test="${page == 1}">
				<%@include file="device.jsp"%>
			</c:if>
			<c:if test="${page == 2}">
				<%@include file="PushResult.jsp"%>
			</c:if>
			<c:if test="${page == 3}">
				<%@include file="PushAdmin.jsp"%>
			</c:if>
			</td>
		</tr>
	</table>
</body>
</html>
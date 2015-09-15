<%@ include file="admin/lib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta property="og:site_name" content="video-hot.appspot.com" />
<meta property="og:type" content="website" />



<meta property="og:title" content="Xem video giải trí " />

<meta property="og:description" content="Xem video giải trí " />


<c:if test="${not empty code}">
	<meta property="og:url"
		content="http://app-video.appspot.com/?v=${code}&packageId=${packageId}" />
	<meta property="og:image"
		content="http://i1.ytimg.com/vi/${code}/1.jpg" />
</c:if>
<title>Video App</title>
<script>
	var isMobile = {
		Android : function() {
			return navigator.userAgent.match(/Android/i);
		},
		BlackBerry : function() {
			return navigator.userAgent.match(/BlackBerry/i);
		},
		iOS : function() {
			return navigator.userAgent.match(/iPhone|iPad|iPod/i);
		},
		Opera : function() {
			return navigator.userAgent.match(/Opera Mini/i);
		},
		Windows : function() {
			return navigator.userAgent.match(/IEMobile/i);
		},
		any : function() {
			return (isMobile.Android() || isMobile.BlackBerry()
					|| isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
		}
	};
	<c:if test="${not empty code}">
	if (isMobile.Android()) {
		location.href = "market://details?id=${packageId}";
	}
	</c:if>
</script>
</head>
<body>
	<h1>wellcome Vieo App</h1>
	<c:if test="${not empty code}">
		<iframe width="854" height="480"
			src="https://www.youtube.com/embed/${code}" frameborder="0"
			allowfullscreen></iframe>
	</c:if>

</body>
</html>
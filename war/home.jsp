<%@ include file="admin/lib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta property="og:site_name" content="video-vl.appspot.com" />
<meta property="og:type" content="website" />
<meta property="og:image" content="${image_url}" />
<meta property="og:title" content="${title} xem nhiều hơn trên : https://play.google.com/store/apps/details?id=${packageId}" />
<meta property="og:description" content="Xem video giải trí" />

<c:if test="${not empty code}">
	<meta property="og:url"
		content="http://video-vl.appspot.com/?v=${query}" />
	<meta property="og:image"
		content="${image_url}" />
</c:if>
<title>${title}</title>
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
		location.href="market://details?id=groupbase.vn.thn.playviewer";
		location.href = "playviewer://video_access_tokens?v=${query}";
	}
	</c:if>
</script>
</head>
<body>
	<h1>wellcome Video App</h1>
	<c:if test="${not empty code}">
		<iframe width="854" height="480"
			src="https://www.youtube.com/embed/${code}" frameborder="0"
			allowfullscreen></iframe>
			<h1>xem nhiều hơn trên</h1> </br><a href="https://play.google.com/store/apps/details?id=${packageId}"><h1>Play Store</h1></a>
	</c:if>

</body>
</html>
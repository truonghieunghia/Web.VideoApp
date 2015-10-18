<%@ include file="admin/lib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/home.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta property="og:site_name" content="videovl.tk" />
<meta property="og:type" content="website" />
<meta property="og:image" content="${image_url}" />
<meta property="og:title" content="${title}" />
<meta property="og:description" content="Xem video giải trí" />

<c:if test="${not empty code}">
	<meta property="og:url" content="http://videovl.tk/?${query}" />
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
		location.href = "market://details?id=groupbase.vn.thn.playviewer";
		location.href = "playviewer://video_access_tokens?v=${query}";
	}
	</c:if>
</script>
</head>
<body>
	<div id="header">
		<div id="headerContent">
			<div id="logo_a"
				style="float: left; margin-bottom: -5px; height: 36px; margin-right: 10px; position: relative; z-index: 100;">
				<a href="//videovl.tk/"> <img src="icon/logo.png" />
				</a>
			</div>
			<ul id="menuBar">
				<li <c:if test="${selected == 5}">class="selected"</c:if>><a
					title="ClipVL" href="/">ClipVL</a></li>
				<li <c:if test="${selected == 1}">class="selected"</c:if>><a
					title="Phim Bộ" href="/danh_muc?appid=phimbo">Phim Bộ</a></li>
				<li <c:if test="${selected == 3}">class="selected"</c:if>><a
					title="Phim lẻ" href="/danh_muc?appid=phimle">Phim lẻ</a></li>
				<li <c:if test="${selected == 7}">class="selected"</c:if>><a
					title="Phim Việt" href="/danh_muc?appid=phimviet">Phim Việt</a></li>
				<li <c:if test="${selected == 6}">class="selected"</c:if>><a
					title="Phim Hài,Clip hài" href="/danh_muc?appid=cliphai">Phim
						Hài,Clip hài</a></li>
			</ul>
		</div>
	</div>


	<div id="content">
		<div id="mainContainer">
			<div id="leftColumn">
				<div class="box">
					<c:if test="${not empty code}">
						<iframe width="665" height="480"
							src="https://www.youtube.com/embed/${code}" frameborder="0"
							allowfullscreen></iframe>
						<h1>xem nhiều hơn trên</h1>
						</br>
						<a
							href="https://play.google.com/store/apps/details?id=${packageId}"><h1>Play
								Store</h1></a>
						<div id="fb-root"></div>
						<script>
							(function(d, s, id) {
								var js, fjs = d.getElementsByTagName(s)[0];
								if (d.getElementById(id))
									return;
								js = d.createElement(s);
								js.id = id;
								js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5";
								fjs.parentNode.insertBefore(js, fjs);
							}(document, 'script', 'facebook-jssdk'));
						</script>								
						<div class="fb-share-button"
							data-href="http://videovl.tk//?${query}"
							data-layout="button_count"></div>
							<div class="fb-comments"
								data-href="http://videovl.tk//?${query}" data-numposts="10"></div>
					</c:if>
					</span>
					<div class="clear"></div>
				</div>

				<!-- <div id="footer">
				<a class="first" style="outline: none; text-decoration: none; color: rgb(85, 85, 85); transition: color 0.2s linear; -webkit-transition: color 0.2s linear; font-weight: bold; margin: 0px 3px 0px 0px; font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;" href="http://haivl.photos/thong-tin-lien-he">Liên hệ</a>
				<span style="font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;"> · </span>
				<a style="outline: none; text-decoration: none; color: rgb(85, 85, 85); transition: color 0.2s linear; -webkit-transition: color 0.2s linear; font-weight: bold; margin: 0px 3px; font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;" href="http://haivl.photos/haivl-hoi-sinh-2">Giới thiệu</a>
				<span style="font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;"> · </span>
				<a style="outline: none; text-decoration: none; color: rgb(85, 85, 85); transition: color 0.2s linear; -webkit-transition: color 0.2s linear; font-weight: bold; margin: 0px 3px; font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;" href="http://haivl.photos/nhung-thac-mac-cua-moi-nguoi-khi-luot-haivl">FAQ</a>
				<span style="font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;"> ·</span>
				<a style="outline: none; text-decoration: none; color: rgb(85, 85, 85); transition: color 0.2s linear; -webkit-transition: color 0.2s linear; font-weight: bold; margin: 0px 3px; font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;" href="http://haivl.photos/dieu-khoan-su-dung-haivl">Điều khoản</a>
				<span style="font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;">· </span>
				<a style="color: rgb(85, 85, 85); outline: none; text-decoration: none; transition: color 0.2s linear; -webkit-transition: color 0.2s linear; font-weight: bold; margin: 0px 3px; font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;" href="http://haivl.photos/cach-lay-lai-tai-khoan-facebook-bi-khoa-va-bat-xac-minh-ban-be">Cách lấy lại tài khoản Facebook bị khóa</a>
				<span style="font-family: arial, verdana, serif; font-size: 12px; line-height: 18px; text-align: center;">· </span>
				<strong>
				<a href="http://haivl.photos/cach-kiem-tien-khung-voi-shared2earn-kiem-tien-tren-mang">Cách kiếm tiền trên mạng</a>
				</strong>
			</div> -->
			</div>
			<div id="rightColumn">
				<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<!-- left -->
<ins class="adsbygoogle"
     style="display:inline-block;width:300px;height:600px"
     data-ad-client="ca-pub-8901310056592294"
     data-ad-slot="2995341160"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>
			</div>
		</div>
	</div>

</body>
</html>
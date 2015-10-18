<%@ include file="lib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/home.css">
<title>VideoVL</title>
</head>
<body>
<div id ="header">
	<div id="headerContent">
		<div id="logo_a" style="float: left;margin-bottom: -5px;height: 36px;margin-right: 10px ;position: relative;z-index: 100;">
			<a  href="//videovl.tk/">
				<img src="icon/logo.png"/>
			</a>
		</div>
		<ul id="menuBar">
			<li <c:if test="${selected == 5}">class="selected"</c:if> ><a title="ClipVL" href="/">ClipVL</a></li>
			<li <c:if test="${selected == 1}">class="selected"</c:if>><a title="Phim Bộ" href="/danh_muc?appid=phimbo">Phim Bộ</a></li>
			<li <c:if test="${selected == 3}">class="selected"</c:if>><a title="Phim lẻ" href="/danh_muc?appid=phimle">Phim lẻ</a></li>
			<li <c:if test="${selected == 7}">class="selected"</c:if>><a title="Phim Việt" href="/danh_muc?appid=phimviet">Phim Việt</a></li>
			<li <c:if test="${selected == 6}">class="selected"</c:if>><a title="Phim Hài,Clip hài" href="/danh_muc?appid=cliphai">Phim Hài,Clip hài</a></li>
		</ul>
	</div>
</div>


<div id ="content">
	<div id="mainContainer">
		<div id="leftColumn">
			<div class="box">
				<h3>Nội dung mới</h3>
				<div class="photoList">
					
					<c:forEach var="data" items="${list.listVideo}">
					<div class="photoListItem" data-nsfw="False" data-newly-listed="True" data-id="36952">
						<div class="listItemSeparator"> </div>
						<div class="thumbnail">
							<a href="/danh_muc?appid=${appid}&list=${data.id}">
							<img class="thumbImg" alt="${data.image_high}" src="${data.image_high}">						
							<img class="videoIndicator" src="/icon/play_icon.png">
							</a>
						</div>
						<div id="info">
							<h2>
							<a href="/danh_muc?appid=${appid}&list=${data.id}">${data.title}</a>
							</h2>
							
						</div>
						<div class="clear"> </div>
					</div>
					</c:forEach>
				</div>
				<span class="buttons nextListPage">
				<a rel="next" href="/danh_muc?appid=${appid}&page=${list.nextPageToken}">Nhấp tiếp để vui hơn</a>
				</span>
				<div class="clear"> </div>
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
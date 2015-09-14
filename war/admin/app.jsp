<c:if test="${action ==0}">
	<div id="content_action">
		<a href="?page=Apps&action=new">Add</a>
	</div>
	<div id="htmldata">
		<table border="1">
			<tr>
				<td colspan="3">Action</td>
				<td>AppID</td>
				<td>App Name</td>
				<td>Version</td>
				<td>Published</td>
				<td>Account</td>
				<td>Api_Key</td>
				<td>StoreAndroid</td>
				<td>StoreIOS</td>
				<td>StoreWinPhone</td>
				<td>Image_Url</td>
				<td>InstallCount</td>
				<td>Message</td>
			<tr>
				<c:forEach var="data" items="${listapp}">
					<tr>
						<td><a href="?page=Apps&action=edit&key=${data.appID}">edit</a></td>

						<td><a href="?page=Apps&action=delete&key=${data.appID}">delete</a></td>
						<td><a href="?page=Pushs&key=${data.appID}">Push</a></td>
						<td>${data.appID}</td>
						<td>${data.appName}</td>
						<td>${data.version}</td>
						<td><c:if test="${data.published == false}">NotPublished</c:if>
							<c:if test="${data.published == true}">Published</c:if></td>
						<td>${data.account}</td>
						<td>${data.api_Key}</td>
						<td>${data.storeAndroid}</td>
						<td>${data.storeIOS}</td>
						<td>${data.storeWinPhone}</td>
						<td>${data.image_Url}</td>
						<td>${data.installCount}</td>
						<td>${data.contentMessage}</td>

					</tr>

				</c:forEach>
		</table>
	</div>
</c:if>
<c:if test="${action ==1}"><%@include file="appForm.jsp"%></c:if>
<c:if test="${action ==2}"><%@include file="appForm.jsp"%></c:if>
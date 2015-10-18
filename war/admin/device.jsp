
<c:if test="${action ==0}">
	<div id="content_action">
		<a href="?action=new">Add</a> Chosse App: <select name="fillter"
			id="AppID" onchange='changeAppID("AppID")'>
			<option value="0">All</option>
			<c:forEach var="data" items="${listapps}">
				<option value="${data.appID}"
					<c:if test="${data.appID == AppID}">selected="selected"</c:if>>
					${data.appName}</option>
			</c:forEach>
		</select>
		total:${total}
	</div>

	<div id="htmldata">
		<%-- <table border="1">
			<tr>
				<td>OS</td>
				<td>DevicesName</td>
				<td>AppID</td>
				<td>AppName</td>
				<td>Version</td>
				<td colspan="1">Action</td>
			<tr>
				<c:forEach var="data" items="${listdevice}">
					<tr>
						<td>${data.OS}</td>
						<td>${data.devicesName}</td>
						<td>${data.appID}</td>
						<td>${data.appName}</td>
						<td>${data.version}</td>
						<td><a
							href="?page=Devices&action=delete&key=${data.keyDevices}">delete</a></td>
					</tr>

				</c:forEach>
		</table> --%>
	</div>
</c:if>

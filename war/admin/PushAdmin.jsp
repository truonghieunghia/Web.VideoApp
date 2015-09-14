Chosse App:
<select name="AppID" id="AppID" onchange='changeBack("AppID")'>
	<option value="0">All</option>
	<c:forEach var="data" items="${listapps}">
		<option value="${data.appID}"
			<c:if test="${data.appID == AppID}">selected="selected"</c:if>>
			${data.appName}</option>
	</c:forEach>
</select>
</div>
<div id="htmldata">
	<form action="/admin?page=Pushs&key=${AppID}" method="post">
		<table border="1">
			<tr>
				<td>action</td>
				<td><select name="push_type"><option value="1">updatekey</option>
						<option value="2">PushNoti</option>
				</select></td>
			</tr>
			<tr>
				<td>Messagme</td>
				<td><textarea rows="3" cols="20" name="Message">${app.contentMessage}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Push" /></td>
			</tr>
		</table>
	</form>
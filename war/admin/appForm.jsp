
<c:if test="${action ==1}">
<form action=<%="/admin?" + request.getQueryString()%>
	method="post">
	<table border="1">
		<tr>
			<td>AppID</td>
			<td><input type="text" name ="AppID"/></td>
		</tr>
		<tr>
			<td>AppName</td>
			<td><input type="text" name="AppName" /></td>
		</tr>
		<tr>
			<td>Api_Key</td>
			<td><input type="text" name="Api_Key" /></td>
		</tr>
		<tr>
			<td>StoreAndroid</td>
			<td><input type="text" name="StoreAndroid" /></td>
		</tr>
		<tr>
			<td>StoreIOS</td>
			<td><input type="text" name="StoreIOS" /></td>
		</tr>
		<tr>
			<td>StoreWinPhone</td>
			<td><input type="text" name="StoreWinPhone" /></td>
		</tr>
		<tr>
			<td>Image_Url</td>
			<td><input type="text" name="Image_Url" /></td>
		</tr>
		<tr>
			<td>Message</td>
			<td><textarea rows="3" cols="20" name="Message"></textarea></td>
		</tr>
		<tr>
			<td>Published</td>
			<td><select name ="Published" >
			<option value = "false">NotPublished</option>
			<option value = "true">Published</option>
			</select></td>
		</tr>
		<tr>
			<td>Account</td>
			<td><input type="text" name="Account" /></td>
		</tr>
		<tr>
			<td>Version</td>
			<td><input type="text" name="Version" /></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${action ==2}">
<form action=<%="/admin?" + request.getQueryString()%>
	method="post">
	<input type="hidden" id ="AppID" value ="${app.appID}"/>
	<table border="1">
		<tr>
			<td>AppName</td>
			<td><input type="text" name="AppName"  value ="${app.appName}"/></td>
		</tr>
		<tr>
			<td>Api_Key</td>
			<td><input type="text" name="Api_Key" value ="${app.api_Key}"/></td>
		</tr>
		<tr>
			<td>StoreAndroid</td>
			<td><input type="text" name="StoreAndroid" value ="${app.storeAndroid}"/></td>
		</tr>
		<tr>
			<td>StoreIOS</td>
			<td><input type="text" name="StoreIOS" value ="${app.storeIOS}"/></td>
		</tr>
		<tr>
			<td>StoreWinPhone</td>
			<td><input type="text" name="StoreWinPhone" value ="${app.storeWinPhone}"/></td>
		</tr>
		<tr>
			<td>Image_Url</td>
			<td><input type="text" name="Image_Url" value ="${app.image_Url}"/></td>
		</tr>
		<tr>
			<td>Message</td>
			<td><textarea rows="3" cols="20" name="Message">${app.contentMessage}</textarea></td>
		</tr>
		<tr>
			<td>Published</td>
			<td><select name ="Published" >
			<option value = "false">NotPublished</option>
			<option value = "true">Published</option>
			</select></td>
		</tr>
		
		<tr>
			<td>Account</td>
			<td><input type="text" name="Account" value ="${app.account}"/></td>
		</tr>
		<tr>
			<td>Version</td>
			<td><input type="text" name="Version" value ="${app.version}"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form>
</c:if>
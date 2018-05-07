<html>
<body>
	<h2>RESTful Web Application for Workshop3 (Coders Lab Programing Course) project</h2>
	<p>
		Visit <a href="https://github.com/mlipski00/Workshop3-REST-API">my
			GitHub</a> for code repository.<br>
		<br> Specification:<BR>
		<br>
	<table border="1" style="table-layout: fixed; width: 1000px;">
		<tr>
			<th >Resource</th>
			<th>Method</th>
			<th>Type</th>
			<th>Description</th>
		</tr>
		<tr>
			<td>webapi/user</td>
			<td>GET</td>
			<td></td>
			<td>returns list of all users</td>
		</tr>
		<tr>
			<td>webapi/user?userId={userId}</td>
			<td>GET</td>
			<td>int</td>
			<td>returns user</td>
		</tr>
		<tr>
			<td>webapi/user</td>
			<td>POST</td>
			<td></td>
			<td>adds user</td>
		</tr>
		<tr>
			<td>webapi/user/{userId}</td>
			<td>PUT</td>
			<td>int</td>
			<td>updates user</td>
		</tr>
		<tr>
			<td>webapi/user/{userId}</td>
			<td>DELETE</td>
			<td>int</td>
			<td>deletes user</td>
		</tr>
	</table>
	<br>
	<table border="1" style="table-layout: fixed; width: 1000px;">
		<tr>
			<td>webapi/excercise</td>
			<td>GET</td>
			<td></td>
			<td>returns list of all excercises</td>
		</tr>
		<tr>
			<td>webapi/excercise?excerciseId={excerciseId}</td>
			<td>GET</td>
			<td>int</td>
			<td>returns excercise</td>
		</tr>
		<tr>
			<td>webapi/excercise</td>
			<td>POST</td>
			<td></td>
			<td>adds excercise</td>
		</tr>
		<tr>
			<td>webapi/excercise/{excerciseId}</td>
			<td>PUT</td>
			<td>int</td>
			<td>updates excercise</td>
		</tr>
		<tr>
			<td>webapi/excercise/{excerciseId}</td>
			<td>DELETE</td>
			<td>int</td>
			<td>deletes excercise</td>
		</tr>
	</table>

<br>
	<table border="1" style="table-layout: fixed; width: 1000px;">
		<tr>
			<td>webapi/group</td>
			<td>GET</td>
			<td></td>
			<td>returns list of all groups</td>
		</tr>
		<tr>
			<td>webapi/group?groupId={groupId}</td>
			<td>GET</td>
			<td>int</td>
			<td>returns group</td>
		</tr>
		<tr>
			<td>webapi/group</td>
			<td>POST</td>
			<td></td>
			<td>adds group</td>
		</tr>
		<tr>
			<td>webapi/group/{groupId}</td>
			<td>PUT</td>
			<td>int</td>
			<td>updates group</td>
		</tr>
		<tr>
			<td>webapi/group/{groupId}</td>
			<td>DELETE</td>
			<td>int</td>
			<td>deletes group</td>
		</tr>
		</table>
		<br>
	<table border="1" style="table-layout: fixed; width: 1000px;">
		<tr>
			<td>webapi/solution</td>
			<td>GET</td>
			<td></td>
			<td>returns list of all solutions</td>
		</tr>
		<tr>
			<td>webapi/solution?solutionId={solutionId}</td>
			<td>GET</td>
			<td>int</td>
			<td>returns solution</td>
		</tr>
		<tr>
			<td>webapi/solution</td>
			<td>POST</td>
			<td></td>
			<td>adds solution</td>
		</tr>
		<tr>
			<td>webapi/solution/{solutionId}</td>
			<td>PUT</td>
			<td>int</td>
			<td>updates solution</td>
		</tr>
		<tr>
			<td>webapi/solution/{solutionId}</td>
			<td>DELETE</td>
			<td>int</td>
			<td>deletes solution</td>
		</tr>
	</table>
</body>
</html>

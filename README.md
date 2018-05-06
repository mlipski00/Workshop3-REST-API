# Workshop3-REST-API

Implementation of Jersey JAX WS for Workshop3 project: http://mlipski.site:8080/Workshop3WS/<br>
API consumes and returns JSON media type.

Specification:<BR>
<table>
<tr>
<th>Resource</th>
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


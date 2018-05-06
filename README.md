# Workshop3-REST-API

Implementation Jersey JAX WS for Workshop3 project.<br>
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
<td>/user</td>
<td>GET</td>
<td></td>
<td>returns list of all users</td>
</tr>
<tr>
<td>/user?userId={userId}</td>
<td>GET</td>
<td>int</td>
<td>returns user</td>
</tr>
<tr>
<td>/user</td>
<td>POST</td>
<td></td>
<td>adds user</td>
</tr>
<tr>
<td>/user/{userId}</td>
<td>PUT</td>
<td>int</td>
<td>updates user</td>
</tr>
<tr>
<td>/user/{userId}</td>
<td>DELETE</td>
<td>int</td>
<td>deletes user</td>
</tr>


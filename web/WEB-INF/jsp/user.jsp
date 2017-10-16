<%@include file="header.jsp" %>

<h1 style="color: red">Manage User Accounts</h1>
<table class="table">
    <tr>
        <th>User Id</th>
        <th>User Name</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <c:forEach var="user" items="${userList}">
    <tr>
        <td>${user.userId}</td>
        <td>${user.userName}</td>
        <td>${user.password}</td>
        <td>${user.role}</td>
        <td> <button type="button" style="background-color: red;color:black;font:larger">Edit</button></td>
        <td> <button type="button" style="background-color: green;color:black;font: larger">Delete</button></td>
    </tr>
    </c:forEach>
</table>
<h1>Insert New Account</h1>
<form class="form-control" method="post" action="${BASE_URL}/user/insert" >
    <label>User Name</label>
    <input type="text" name="userName"/>
    <label>Password</label>
    <input type="text" name="password"/>
    <input list="role" name="role"/>
    <datalist id="role">
        <option value="CEO">
        <option value="Admin">
    </datalist>
    <button type="submit">Submit</button>
</form>
    </body>
</html>

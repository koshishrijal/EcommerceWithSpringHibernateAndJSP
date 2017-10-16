<%-- 
    Document   : login
    Created on : May 22, 2017, 8:42:57 PM
    Author     : Koshish Rijal
--%>
<%@include file="header.jsp" %>

<h1>Login</h1>
<%
    if (request.getAttribute("message") != null) {
%>

<script>alert("incorrect username password")</script>
<h1>${message}</h1>
<%
    }
%>
<form class="form-control" method="post" action="${BASE_URL}/index">
    <label>User Name</label>
    <input type="text" name="userName"/>
    <label >Password</label>
    <input type="password" name="password"/>
    <label>Role</label>
    <input list="role" name="role"/>
    <datalist id="role">
        <option value="CEO"/>
        <option value="Admin"/>               
    </datalist>
    <button type="submit" style="background-color:green;color:black">Login</button>
</form>

</body>
</html>

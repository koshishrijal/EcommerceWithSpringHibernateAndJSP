


<%@include file="header.jsp" %>
<h1 style="color:blue">Upload Here</h1>
<form method="post" action="${BASE_URL}/upload/process" enctype="multipart/form-data">
   <label>Product Name</label>
    <select name="productName">
        <c:forEach var="product" items="${productList}">
        <option value="${product.productName}">${product.productName}</option>
        </c:forEach>
    </select> 
    <label>File</label>
    <input type="file" name="upfile"/>
    <button type="submit">Upload</button>
</form>
</body>
</html>

<%-- 
    Document   : category
    Created on : May 4, 2017, 7:27:47 AM
    Author     : Koshish Rijal
--%>
<%@include file="header.jsp" %>

<h1>Category manage</h1>
<h2>List of category</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <c:forEach var="category" items="${categoryList}" >
        <tr>
            <td>${category.categoryId}</td>
            <td>${category.categoryName}</td>
            <td style="color:black;background-color: whitesmoke"><a href="${BASE_URL}/category/edit?id=${category.categoryId}">EDIT</a></td>
            <td style="color:black;background-color: whitesmoke"><a href="${BASE_URL}/category/delete?id=${category.categoryId}" onclick="return    confirm('Do you really want to delete?')">DELETE</a></td>

        </tr>

    </c:forEach>
</table>

<h1>Category Details</h1>

<c:forEach var="category" items="${categoryList}">
    <h2><li>${category.categoryName}</li></h2>
            <c:forEach var="product" items="${category.productList}">

        <h3><li>${product.productName}</li></h3>
            </c:forEach>


</c:forEach>
<form id="category-entry-form" >

    <label>Category Name</label>
    <input type="text" name="categoryName"/>      
    <button id="btn-category-submit">Insert</button>
</form>
</body>
<script>
    $(document).ready(function () {

        $("#btn-category-submit").click(function () {

            console.log($("#category-entry-form").serialize());
            $.post("${BASE_URL}/category/insert", $("#category-entry-form").serialize(), function (data) {
                alert(data);
            });
            return false;

        });


    });
</script>

</html>

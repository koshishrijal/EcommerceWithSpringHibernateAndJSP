<%-- 
    Document   : productedit
    Created on : May 2, 2017, 9:59:45 PM
    Author     : Koshish Rijal
--%>

<%@include file="header.jsp" %>
<a href="${BASE_URL}">Home</a>
<form method="post" id="edit-form">
    <input type="hidden" name="productId" value="${product.productId}"/>
    <div>
        <label>ProductName</label>
        <input type="text" name="productName" value="${product.productName}"/>
    </div>
    <div>
        <label>CostPrice</label>
        <input type="int" name="costPrice" value="${product.costPrice}"/>
    </div>
    <div>
        <label>SellPrice</label>
        <input type="int" name="sellPrice" value="${product.sellPrice}"/>
    </div>
    <div>
        <label>Quantity</label>
        <input type="int" name="quantity" value="${product.quantity}"/>
    </div>
    <div>
        <label>Status</label>
        <input type="int" name="status" value="${product.status}"/>
    </div>
    <select name="category.categoryId">
        <option value="${product.category.categoryId}">${product.category.categoryName}</option>
        <c:forEach var="category" items="${categoryList}">
            <option value="${category.categoryId}">${category.categoryName}</option>    
        </c:forEach>
    </select>
    <div>
        <button id="btn-submit">
            enter
        </button>
    </div>
</form>
</body>
<script>
    $(document).ready(function () {

        $("#btn-submit").click(function () {
            console.log($("#edit-form").serialize());
            $.post("${BASE_URL}/update", $("#edit-form").serialize(), function (data) {

                alert(data);
                });
            
            return false;
        });


    });
</script>

</html>

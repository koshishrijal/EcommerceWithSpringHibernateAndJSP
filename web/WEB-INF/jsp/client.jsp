<%@include file="header.jsp" %>
<%
    if (session.getAttribute("customer") != null) {
%>
<h1 style='color: #c9302c'> Thank you for the shopping ${sessionScope.customer.customerName} </h1>
<%
        session.invalidate();
    }

%>

      
<h1>Shopping Cart</h1>
<h2>View Cart cart</h2>
<c:forEach var="category" items="${categoryList}">
    <div class="jumbotron">
        <h1>${category.categoryName}</h1>
        <c:forEach var="product" items="${category.productList}">
            <h2>${product.productName}</h2>
            <img src="${BASE_URL}/resources/images/${product.productName}.jpeg" alt="${product.productName} image" style="width:304px;height:228px"/>
            <form method="post" action="${BASE_URL}/client/add">
                <input type="hidden"  name="productId" value="${product.productId}"/> 
                <h2>SELECT Quantity</h2> <select name="quantityBought">
                    <c:forEach  var="i" begin="1" step="1" end="${product.quantity}">

                        <option value="${i}">${i}</option>
                    </c:forEach>

                </select>
                <h2><button type="submit">Add to Cart</button></h2>
            </form>
        </c:forEach>
    </div>

</c:forEach>
</body>
</html>

<%@include file="header.jsp" %>
<div id="cart-control">
    <h1 style="color:blue">Shopping Cart</h1>

    <h1><a href="${BASE_URL}/client/continue">Continue Shopping</a></h1>
    <Button type="button" id="stop-shopping">Stop shopping and make a bill</Button>
</div>
<table class="table" style="visibility: visible" id="cart-table">
    <tr style="color:red;font-size: x-large">
        <th>S/N</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Unit Price</th>
        <th>Total Price</th>
    </tr>
    <c:forEach var="productInfo" items="${sessionScope.productInfoList}" varStatus="loop">
        <c:set var="cost" value="${productInfo.sellPrice}" />
        <tr>
            <td>${loop.count}</td>
            <td>${productInfo.productName}</td>
            <td>${productInfo.categoryName}</td>
            <td>${productInfo.quantityBought}</td>
            <td> ${productInfo.sellPrice/productInfo.quantityBought}</td>
            <td id="sell-price-${loop.count}">${productInfo.sellPrice}</td>

        <tr/>
    </c:forEach>

    <tr>
        <th id="grand-total">GRAND TOTAL</th>
        <th style="color:green">${sessionScope.purchaseDetailInfo.totalPrice}</th>
    </tr>
    <tr>
        <th id="total-discount-obtained">Total Discount Obtained</th>
        <th style="color:green">${sessionScope.purchaseDetailInfo.totalDiscount}</th>
    </tr>


</table>

<div id="login-control" style="visibility: hidden">
    <form class="form-control" method="post" action="${BASE_URL}/customer/insert">
        <label>Name</label><input type="text" name="customerName" required="required"/>
        <label>Address</label><input type="text" name="customerAddress" required="required"/>
        <label>Email</label><input type="email" name="customerEmail" required="required"/>
        <label>Phone number</label><input type="text" name="customerPhoneNumber" required="required"/>
        <label>PAY TYPE</label><input list="pay-type" name="payType" required="required"/>
        <datalist id="pay-type">
            <option value="cash"></option>
            <option value="cheque"></option>

        </datalist>
        <Button type="submit" id="confirm-button" style="color: red;font-size: larger">Confirm Shopping</button>
    </form>
</div>
<!--  + sign in getBy in below js code id parses the value into integer value -->
<!--script>
    var total = 0;
    var sellPrice1 = +document.getElementById("sell-price-1").innerHTML;
    var sellPrice2 = +document.getElementById("sell-price-2").innerHTML;
    total = sellPrice1 + sellPrice2;
    var grandTotal = document.getElementById("grand-total");
    grandTotal.innerHTML = total;
    </script-->
<script>
    var loginControl = document.getElementById("login-control");
    var cartControl = document.getElementById("cart-control");
    var tblCart = document.getElementById("cart-table")
    var stopShopping = document.getElementById("stop-shopping");
    stopShopping.addEventListener("click", function () {
        loginControl.style.visibility = "visible";
        cartControl.style.visibility = "hidden";

    });

</script>
</body>
</html>

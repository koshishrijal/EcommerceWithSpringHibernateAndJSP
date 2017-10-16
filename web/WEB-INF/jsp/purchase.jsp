<%-- 
    Document   : purchase
    Created on : May 8, 2017, 8:58:26 AM
    Author     : Koshish Rijal
--%>

<%@include file="header.jsp" %>
<h1>Purchase Manager</h1>
<table class="table">
    <tr>
        <th style="color: red"><h1>Grand Profit Till Now</h1></th>     
<td> <h1>${grandtotalProfit}</h1> </td>  
    </tr>
    <tr><th><h1 style="color:green">Transactions</h1></th></tr>
    <tr>
        <th>Date of Transactions</th>
        <th>Customer Name</th>
        <th>Total profit of this Transaction</th>
       <th>Total price paid</th>
       <th>Products Bought</th>
    </tr>
    <c:forEach var="purchaseModel" items="${purchaseModelList}">
    <tr>       
        <td>${purchaseModel.purchaseDate}</td>
        <td>${purchaseModel.customer.customerName}</td>
        <td>${purchaseModel.totalProfit}</td>
        <td>${purchaseModel.totalPrice}</td>
        <td><c:forEach var="product" items="${purchaseModel.productList}">
        <li>${product.productName}</li>
            </c:forEach></td>
    </tr>
    </c:forEach>
    
</table>
</body>
</html>

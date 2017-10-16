<%-- 
    Document   : customer
    Created on : May 5, 2017, 6:21:52 PM
    Author     : Koshish Rijal
--%>
<%@include file="header.jsp" %>
<h1>Customer Manage</h1>
<h2>Customer list</h2>
<div class="jumbotron">
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Customer Name</th>
            <th> Phone Number</th>
            <th>Email Address</th>
            <th>Address</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="loop">

            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.customerName}</td>
                <td>${customer.customerPhoneNumber}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerAddress}</td>
                <td>
                    <button><a href="${BASE_URL}/customer/edit/${customer.customerId}">EDIT</a></button>
                </td>
                <td>
                        <button><a href="${BASE_URL}/customer/delete?id=${customer.customerId}" onclick="return confirm('are you sure to delete?')">DELETE</a></button>
                    
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
<div class="jumbotron">
    <form id="customer-form" >
        <label>Customer Name</label>
        <input required="required" type="text" name="customerName"/>
        <label>Phone Number</label>
        <input type="number" required="required" name="customerPhoneNumber"/>
        <label>Email</label>
        <input required="reqiured" type="email" name="customerEmail"/>
        <label>Address</label>   
        <input required="required" type="text" name="customerAddress"/>
        <button type="submit" id="btn-submit">Submit</button>

    </form>
</div>
<script>
    $(document).ready(function () {
        $("#btn-submit").click(function () {
            $.post("${BASE_URL}/customer/insert", $("#customer-form").serialize(), function (data) {
                alert(data);
            });
            return false;
        });

    });
</script>
</body>
</html>

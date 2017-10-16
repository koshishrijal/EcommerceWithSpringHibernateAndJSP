<%@include file="header.jsp" %>
        <h1>Hello World!</h1>
        
        
        <div class="jumbotron">
    <form id="customer-edit-form" >
        <input type="hidden" name="customerId" value="${customer.customerId}"/>
        <label>Customer Name</label>
        <input required="required" type="text" name="customerName" value="${customer.customerName}"/>
        <label>Phone Number</label>
        <input type="number" required="required" name="customerPhoneNumber" value="${customer.customerPhoneNumber}"/>
        <label>Email</label>
        <input required="reqiured" type="email" name="customerEmail" value="${customer.customerEmail}"/>
        <label>Address</label>   
        <input required="required" type="text" name="customerAddress" value="${customer.customerAddress}"/>
        <button type="submit" id="btn-submit">Submit</button>

    </form>
</div>
    </body>
    <script>
        $(document).ready(function(){
            $("#btn-submit").click(function(){
                $.post("${BASE_URL}/customer/update",$("#customer-edit-form").serialize(),function(data){
                     alert(data);
                     });
                     return false;
            });
            
        });
        
    </script>
</html>

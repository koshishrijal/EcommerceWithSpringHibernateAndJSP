

<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<h1 style="color:red">Total Hits To The Site Till Date</h1>
<h1>${applicationScope.hits}</h1>
<div class="jumbotron">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
                <h2>  <span class="label label-warning"> <a href="${BASE_URL}/purchase">purchase Manager</a></span></h2>
                
                
            </div>
            <div class="col-md-4">
                <h2>  <span class="label label-info"><a href="${BASE_URL}/user">User Account Manager</a></span></h2>
               
            </div>
            <div class="col-md-4">
                <h2>  <span class="label label-danger"><a href="${BASE_URL}/category">Category Manager</a></span></h2>
                
            </div>
        </div>
                 <div class="row">
            <div class="col-md-4">
                <h2>  <span class="label label-warning"> <a href="${BASE_URL}/purchase">purchase Manager</a></span></h2>
                
                
            </div>
            <div class="col-md-4">
                <h2>  <span class="label label-info"><a href="${BASE_URL}/upload">Upload Manager</a></span></h2>
                
            </div>
            <div class="col-md-4">
                <h2>  <span class="label label-danger"><a href="${BASE_URL}/customer">Customer Manager</a></span></h2>
                 
            </div>
        </div>
      </div>
</div>

                 
                 
                 
<div class="jumbotron">
    <div class="container-fluid">
        <div class="row">
                <div class="col-md-3">
                <h2>  <span class="label label-success">Total Profit Till date</span></h2>
                <h1>${totalProfitTillDate}</h1>
                
            </div>
            <div class="col-md-3">
                <h2>  <span class="label label-primary">Total Profit Today</span></h2>
                <h1>${totalProfitToday}</h1>
                
            </div>
            <div class="col-md-3">
                <h2>  <span class="label label-info">Total Site Visit Today</span></h2>
                <h1 id="visits-id"></h1>
            </div>
            <div class="col-md-3">
                <h2>  <span class="label label-danger">Total Purchase Today</span></h2>
                 <h1>50</h1>
            </div>
        </div>
      </div>
</div>
                


   
<div class="jumbotron">
    <h1><a href="${BASE_URL}/client">Client View</a></h1>
    <h1><a href="${BASE_URL}/purchase">purchase Manager</a></h1>
    <h1><a href="${BASE_URL}/upload">Upload Manager</a></h1>
    <h1><a href="${BASE_URL}/customer">Customer Manager</a></h1>
    <h1><a href="${BASE_URL}/user">User Account Manager</a></h1>
    <h1><a href="${BASE_URL}/category">Category Manager</a></h1>
    
</div>
    <div class="jumbotron">
        <h1 style="color:blue">MANAGE PRODUCTS</h1>
    <table class="table">
        <tr>
            <th>Product Name</th>
            <th>category</th>
            <th>cost price</th>
            <th>Sell price</th>
            <th>Quantity</th>
            <th>Status</th>

        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>

                <td><div contenteditable="true" id="product-name">${product.productName}</div></td>
                <td><div contenteditable="true" id="category-name">${product.category.categoryName}</div></td>
                <td><div contenteditable="true" id="cost-price">${product.costPrice}</div></td>
                <td><div contenteditable="true" id="sell-price">${product.sellPrice}</div></td>
                <td><div contenteditable="true" id="quantity">${product.quantity}</div></td>
                <td><div contenteditable="true" id="status">${product.status}</div></td>
                <td><button style="background-color: green" ><a href="${BASE_URL}/edit?id=${product.productId}">EDIT</a></button></td> 
                <td><button style="background-color: red" ><a href="${BASE_URL}/delete/${product.productId}" onclick="return    confirm('Do you really want to delete?')" >DELETE</a></button></td> 

            </tr>



        </c:forEach> 
    </table>
</div>
    <div class="jumbotron">
<form id="product-form" class="form-control">


    <label>Product Name</label>
    <input  type="text" name="productName" required="required"/>

    <label>Cost Price</label>
    <input type="int" name="costPrice" required="required"/>

    <label>Sell Price</label>
    <input type="int" name="sellPrice"required="required"/>

    <label>Quantity</label>
    <input type="int" name="quantity" required="required"/>

    <label>Status</label>
    <input type="int" name="status" required="required"/>

    <select name="category.categoryId">
        <option value="">Category</option>
        <c:forEach var="category" items="${categoryList}">
            <option value="${category.categoryId}">${category.categoryName}</option>    
        </c:forEach>
    </select>

    <button id="btn-submit" style="background-color:green;color:black">
        Enter
    </button>

</form>
    </div>
</body> 
<script>
    var totalProfittodayBox=document.getElementById("profit-box");
    var totalViewToday=document.getElementById("total-site-visit-today-box");
    var visitsId=document.getElementById("visits-id");
    
    
    $(document).ready(function () {

        $("#btn-submit").click(function () {

            console.log($("#product-form").serialize());
            $.post("${BASE_URL}/insert", $("#product-form").serialize(), function (data) {
                alert(data);
            });
            return false;

        });


    });
</script>
</html>

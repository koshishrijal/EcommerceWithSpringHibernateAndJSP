<%@include file="header.jsp" %>
<body>
    <h1>Hello World!</h1>
    <form id="input-form">
        <label>Category Name</label>
        <input type="text" value="${category.categoryName}" name="categoryName"/>
        <input type="hidden" value="${category.categoryId}" name="categoryId"/>
        <button type="button" id="btn-submit">Submit
        </button>
    </form>
</body>
<script>
    $(document).ready(function () {
        $("#btn-submit").click(function () {
            console.log($("#input-form").serialize());
            $.post("${BASE_URL}/category/update", $("#input-form").serialize(), function (data) {
                alert(data);
            });
            return false;
        });
    });
</script>
</html>

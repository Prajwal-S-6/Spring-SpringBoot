<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<head>
    <title>Add Todo</title>
</head>
<body>

<div class="container">
    <h1>Enter Todo details</h1>
    <form method="post" class="form">
        Description: <input type="text" name="description" required="required"/>
        <input type="submit" class="btn btn-success">
    </form>
</div>

</body>
</html>
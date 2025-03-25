<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<head>
    <title>TodoList</title>
</head>
<body>
<div class="container">
    <div>Welcome, ${username}</div>
    <hr/>
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.getId()}</td>
                <td>${todo.getDescription()}</td>
                <td>${todo.getTargetDate()}</td>
                <td>${todo.isDone()}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
</body>
</html>
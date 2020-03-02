<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ToDos for ${name}</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
    <body>
        <div class="container">
            <h1>Your ToDos</h1>
            <table class="table table-striped">
                <caption>Your ToDos are:</caption>
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is it Done?</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.desc}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div>
                 <a  class="button" href="/add-todo">Add a ToDo</a>
            </div>
            <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
            <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>


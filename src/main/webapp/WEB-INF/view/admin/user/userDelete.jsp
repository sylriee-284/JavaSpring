<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <!-- Latest compiled and minified CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        </head>

        <body>
            <div class="container mt-5  ">
                <h1>Delete The User With ID = ${userId}</h1>
                <div class="alert alert-danger" role="alert">
                    Are you sure to delete this user?
                </div>
                <form action="/admin/user/delete/${userId}" method="post">
                    <button type="submit" class="btn btn-danger">Confirm</button>
                    <a href="/admin/user" class="btn btn-secondary">Cancel</a>
            </div>
        </body>

        </html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books!</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
    <h1>All Books</h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Language</th>
            <th scope="col">Number of Pages</th>
            <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.description}"/></td>
            <td><c:out value="${book.language}"/></td>
            <td><c:out value="${book.numberOfPages}"/></td>
            <td><a href="/books/${book.id}">View Book Details</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">New Book</a>
</body>
</html>


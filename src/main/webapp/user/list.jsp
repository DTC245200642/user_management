<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
    <center>
        <h1>User Management</h1>
    </center>

    <div align="center">
        <!-- Form Tìm kiếm theo quốc gia -->
        <form method="get" action="users">
            <input type="hidden" name="action" value="search"/>
            <label>Tìm kiếm theo Quốc gia: </label>
            <input type="text" name="country" placeholder="Nhập quốc gia..."/>
            <input type="submit" value="Tìm kiếm"/>
        </form>

        <br>

        <!-- Nút Sắp xếp theo tên và Làm mới -->
        <a href="users?action=sort">
            <button type="button">Sắp xếp theo Tên (A-Z)</button>
        </a>
        <a href="users">
            <button type="button">Làm mới danh sách</button>
        </a>

        <br><br>

        <!-- Bảng hiển thị danh sách User -->
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
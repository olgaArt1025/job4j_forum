<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/save'/>" method='post'>
    <c:if test="${not empty post}">
        <input type="hidden" name="id" value="${post.id}">
    </c:if>
    <table>
        <table>
            <tr>
                <td>Тема</td>
                <td><input type='text' name='name' value="${post.name}"></td>
            </tr>
            <tr>
                <td>Описание</td>
                <td><input type='text' name='description' value="${post.description}"></td>
            </tr>
            <tr>
                <td><input class="btn btn-primary btn-sm" type="submit" value="Сохранить"/></td>
            </tr>
        </table>
    </table>
</form>
</body>
</html>
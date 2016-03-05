<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="styles/styles.css">
    <title>Cat Profile</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<jsp:useBean id="cat" scope="request" class="by.grsu.cats.editor.beans.CatBean"/>
<jsp:setProperty name="cat" property="*"></jsp:setProperty>

<table class="profileTable">
    <tr>
        <td>
            <div style="background-color: ${'#'}${cat.color}">
                <img class="image" src="pics/cat.png"/>
            </div>
        </td>
        <td>
            <form action="/applyCatChange.jsp" method="post">
                <input type="hidden" name="hash" value="${cat.hash}">
                <div>
                    <div>Cat's name</div>
                    <c:choose>
                        <c:when test="${cat.nameValid}">
                            <input type="text" name="name" value="${cat.name}">
                        </c:when>
                        <c:otherwise>
                            <input class="error" type="text" name="name" value="${cat.name}">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div>
                    <div>Cat's color</div>
                    <c:choose>
                        <c:when test="${cat.colorValid}">
                            <input type="text" name="color" value="${cat.color}">
                        </c:when>
                        <c:otherwise>
                            <input class="error" type="text" name="color" value="${cat.color}">
                        </c:otherwise>
                    </c:choose>
                </div>
                <input type="submit" name="save" value="save">
                <input type="submit" name="remove" value="remove">
            </form>
        </td>
    </tr>
</table>

<jsp:include page="footer.jsp"/>
</body>
</html>

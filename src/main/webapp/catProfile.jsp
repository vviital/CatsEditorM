<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>

<html>
<head>`
    <title>Cat Profile</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<jsp:useBean id="cat" scope="request" class="by.grsu.cats.editor.beans.CatBean">
    <jsp:setProperty name="cat" property="*"></jsp:setProperty>
</jsp:useBean>

    <table>
        <tr>
            <td>
                <div>
                    <img class="image" src="pics/cat.png"/>
                </div>
            </td>
            <td>
                <form action="/profileController" method="post">
                    <div>
                        <div>Cat's name</div>
                        <input type="text" name="name" value="${cat.name}">
                    </div>
                    <div>
                        <div>Cat's color</div>
                        <input type="text" name="color" value="${cat.color}">
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

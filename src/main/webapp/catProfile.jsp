<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="styles/styles.css">
    <title>Cat Profile</title>
</head>
<body>

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
</body>
</html>

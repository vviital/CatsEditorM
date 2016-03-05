<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="styles/styles.css">
    <title>Cat Catalog</title>
</head>
<body>

<jsp:useBean id="catSave" class="by.grsu.cats.editor.beans.CatBean" scope="page">
    <jsp:setProperty name="catSave" property="name" param="name"></jsp:setProperty>
    <jsp:setProperty name="catSave" property="color" param="color"></jsp:setProperty>
</jsp:useBean>

<jsp:useBean id="catsCollection" class="by.grsu.cats.editor.beans.CatsCollectionBean" scope="session"/>

<div>
    <form action="catValidate.jsp" method="post">
        <input type="text" hidden name="hash" value="${cat.hash}">
        <div>
            <c:choose>
                <c:when test="${catSave.nameValid}">
                    <input type="text" name="name" value="<c:out value="${catSave.name}"/>"/>
                </c:when>
                <c:otherwise>
                    <input class="error" type="text" name="name" value="<c:out value="${catSave.name}"/>"/>
                </c:otherwise>
            </c:choose>
        </div>
        <div>
            <c:choose>
                <c:when test="${catSave.colorValid}">
                    <input type="text" name="color" value="<c:out value="${catSave.color}"/>"/>

                </c:when>
                <c:otherwise>
                    <input class="error" type="text" name="color" value="<c:out value="${catSave.color}"/>"/>
                </c:otherwise>
            </c:choose>
        </div>
        <input type="submit">
    </form>
</div>

<div>
    <c:forEach items="${catsCollection.catBeanMap}" var="item">
        <form action="catProfile.jsp" method="post">
            <div class="divBorder">
                <div style="background-color: ${'#'}${item.value.color}">
                    <img class="image" src="pics/cat.png"/>
                </div>
                <input type="submit" value="${'edit '}${item.value.name}"/>
            </div>
        </form>
    </c:forEach>

</div>

</body>
</html>

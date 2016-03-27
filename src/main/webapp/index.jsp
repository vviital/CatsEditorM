<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="styles/styles.css">
    <title>Cat Catalog</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<jsp:useBean id="catSave" class="by.grsu.cats.editor.beans.Cat" scope="page">
    <jsp:setProperty name="catSave" property="name" param="name"></jsp:setProperty>
    <jsp:setProperty name="catSave" property="color" param="color"></jsp:setProperty>
</jsp:useBean>

<jsp:useBean id="catsCollection" class="by.grsu.cats.editor.beans.CatsCollectionBean" scope="session"/>

<div>
    <form action="catValidate.jsp" method="post">
        <fieldset>
            <legend><h2 style="color:azure">Add new funny cat</h2></legend>
            <input type="text" hidden name="hash" value="${cat.hash}">
            <div class="addFormItems">
                <div class="fontsClass">
                    Cat's name
                </div>
                <c:choose>
                    <c:when test="${catSave.nameValid || param.name == null}">
                        <input class="inputText" type="text" name="name" value="<c:out value="${catSave.name}"/>"/>
                    </c:when>
                    <c:otherwise>
                        <input class="inputText error" type="text" name="name" value="<c:out value="${catSave.name}"/>"/>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="addFormItems">
                <div class="fontsClass">
                    Cat's color
                </div>
                <c:choose>
                    <c:when test="${catSave.colorValid || param.color == null}">
                        <input class="inputText" type="text" name="color" value="<c:out value="${catSave.color}"/>"/>
                    </c:when>
                    <c:otherwise>
                        <input class="inputText error" class="error" type="text" name="color" value="<c:out value="${catSave.color}"/>"/>
                    </c:otherwise>
                </c:choose>
            </div>
            <input type="submit" value="add cat!"/>
        </fieldset>
    </form>
</div>

<div>
    <c:forEach items="${catsCollection.catBeanMap}" var="item">
    <div class="divBorder">
        <form action="catProfile.jsp" method="post">
                <div style="background-color: ${'#'}${item.value.color}">
                    <img class="image" src="pics/cat.png"/>
                </div>
                <input type="hidden" name="color" value="${item.value.color}"/>
                <input type="hidden" name="hash" value="${item.value.hash}"/>
                <input type="hidden" name="name" value="${item.value.name}"/>
                <input class="inputText" type="submit" value="${'edit '}${item.value.name}"/>
        </form>
    </div>
    </c:forEach>

</div>

<jsp:include page="footer.jsp"/>

</body>
</html>

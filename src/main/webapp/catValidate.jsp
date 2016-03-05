<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="styles/styles.css">
    <title></title>
</head>
<body>

<jsp:useBean id="cat" class="by.grsu.cats.editor.beans.CatBean" scope="request"/>

<jsp:setProperty name="cat" property="name" param="name"></jsp:setProperty>
<jsp:setProperty name="cat" property="color" param="color"></jsp:setProperty>

<% System.out.println(cat.toString());
    Enumeration<String> arr = request.getParameterNames();
    while(arr.hasMoreElements()) {
        String cur = arr.nextElement();
        System.out.println(cur + " = " + request.getParameter(cur));
    }
%>;
<c:choose>
    <c:when test="${cat.colorValid && cat.nameValid}">
        <jsp:forward page="catProfile.jsp">
            <jsp:param name="hash" value="${cat.hash}"/>
        </jsp:forward>
    </c:when>
    <c:otherwise>
        <jsp:forward page="index.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>

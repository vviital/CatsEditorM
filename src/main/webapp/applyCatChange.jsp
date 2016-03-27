<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <jsp:useBean id="cat" class="by.grsu.cats.editor.beans.Cat" scope="session"/>
    <jsp:setProperty name="cat" property="*"/>

    <%
        System.out.println(cat.toString());
        System.out.println(request.getParameter("save"));
        System.out.println(request.getParameter("remove"));
    %>
    <jsp:forward page="/profileController">
        <jsp:param name="save" value="${param.save}"/>
        <jsp:param name="remove" value="${param.remove}"/>
    </jsp:forward>
</body>
</html>
